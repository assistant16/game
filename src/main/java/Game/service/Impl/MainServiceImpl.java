package Game.service.Impl;

import Game.WebSocket.Sessions;
import Game.dto.PageDto;
import Game.entity.AnswerBoard;
import Game.entity.CurrentQuestion;
import Game.entity.Question;
import Game.entity.Score;
import Game.repository.AnswerBoardRepository;
import Game.repository.CurrentQuestionRepository;
import Game.repository.QuestionRepository;
import Game.repository.ScoreRepository;
import Game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
@Transactional
public class MainServiceImpl implements MainService {

    public static final int GAME_DELAY = 15000;
    public static final int ANSWER_DELAY = 5000;

    @Autowired
    HttpSession session;

    @Autowired
    AnswerBoardRepository answerBoardRepository;

    @Autowired
    CurrentQuestionRepository currentQuestionRepository;

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    Sessions sessions;




    @Override
    public synchronized PageDto guess(int variant, String email) {

        int bestNumber;
        String systemResponse;
        long newAnswerDelay=0L;

        AnswerBoard bestVariant = answerBoardRepository.findTop1ByOrderByIdDesc();

        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();
        int answer = currentQuestion.getCurrentAnswer();
        int FirstNumberFlag = 1;

        PreparingScors(email);

        if (bestVariant != null) { bestNumber = bestVariant.getCurrentAnswer(); }
        else {
            bestNumber = variant;
            FirstNumberFlag = 0;
        }





        if (new Date().getTime() - scoreRepository.findByEmail(email).getDateAnswerGiven().getTime() < 2000 && FirstNumberFlag==1) {
            long elapsedAfterSendVariant = (System.currentTimeMillis() - scoreRepository.findByEmail(email).getDateAnswerGiven().getTime());
            newAnswerDelay = (ANSWER_DELAY - elapsedAfterSendVariant) / 1000;
            systemResponse = " for example ";

        }
            else {

            if (variant == answer) {                                   /////check if won

                plusOneToScore(email);

                currentQuestion.setSolved(true);
                SaveBestNumberAndDate(variant, email);
                sessions.broadcast("refresh");

                Timer gameTimer = new Timer();
                gameTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        begin();
                        sessions.broadcast("refresh");


                    }
                }, GAME_DELAY);
                //findByIdLessThanOrderByIdDesc
                //answerBoardRepository.deleteAll();

                Date date = new Date();
                CurrentQuestion currentQuestion1 = currentQuestionRepository.findFirstBy();
                currentQuestion1.setDate(date);
                currentQuestionRepository.save(currentQuestion1);

                systemResponse = "win";


            } else {
                if ((FirstNumberFlag == 0)) {   //need to replace Math.abs(variant - answer) == Math.abs(bestNumber - answer) &&
                    SaveBestNumberAndDate(variant, email);
                    sessions.broadcast("refresh");
                    systemResponse = "Great begin";
                    //FirstNumberFlag = 1;

                } else {
                    if (Math.abs(variant - answer) < Math.abs(bestNumber - answer)) {

                        bestNumber = variant;
                        SaveBestNumberAndDate(variant, email);
                        sessions.broadcast("refresh");
                        systemResponse = "It's better";
                    } else {
                        systemResponse = "It's worse";
                    }
                }
            }
        }
        PageDto pageDto = this.getPage(session);       //some questions
        pageDto.setSystemResponse(systemResponse);
        pageDto.setNewAnswerDelay((int) newAnswerDelay);
        return pageDto;
    }


    @Override
    public PageDto getPage(HttpSession session) {

        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();

        PageDto pageDto = new PageDto();
        prepareAnswerBoard(pageDto);
        pageDto.setCurrentQuestion(currentQuestion.getCurrentQuestionName());
        pageDto.setTop(scoreRepository.findAllByOrderByNumberScoreDesc());
        if (currentQuestion.getDate() != null) {
            long elapsedAfterGameEnd = (System.currentTimeMillis() - currentQuestion.getDate().getTime());
            long newGameDelay = (GAME_DELAY - elapsedAfterGameEnd) / 1000;
            if (newGameDelay > 0) {
                pageDto.setNewGameDelay((int) newGameDelay);
            }
//            if((int)newGameDelay == 0) {
//               begin();
//            }
        }
        return pageDto;
    }

    @Override
    public void begin() {

        CurrentQuestion forCheck = currentQuestionRepository.findFirstBy();

        if (forCheck == null || forCheck.isSolved()) {
            CurrentQuestion currentQuestion = new CurrentQuestion();
            Question RandomQuestion = questionRepository.findRandom();
            if (forCheck != null) {
                Date savedDate = forCheck.getDate();
                currentQuestion.setDate(savedDate);
            }
            answerBoardRepository.deleteAll();
            currentQuestionRepository.deleteAll();
            currentQuestion.setCurrentQuestionName(RandomQuestion.getQuestion());
            Random random = new Random();
            currentQuestion.setCurrentAnswer(random.nextInt(100));
            currentQuestion.setSolved(false);

            currentQuestionRepository.save(currentQuestion);
        }
    }


    private void PreparingScors(String email) {
        Score sessionScoreCheck = scoreRepository.findByEmail(email);
        if (sessionScoreCheck == null) {
            Score score = new Score();
            score.setEmail(email);
            score.setNumberScore(0);
            score.setDateAnswerGiven(new Date());
            scoreRepository.save(score);

        }
    }

    private void SaveBestNumberAndDate(int variant, String email) {
        Score score = scoreRepository.findByEmail(email);
        score.setDateAnswerGiven(new Date());
        AnswerBoard newAnswerBoard = new AnswerBoard();
        newAnswerBoard.setCurrentAnswer(variant);
        newAnswerBoard.setEmail(email);
        answerBoardRepository.save(newAnswerBoard);
    }

    public void prepareAnswerBoard(PageDto pageDto) {
        AnswerBoard top1ByOrderByIdDesc = answerBoardRepository.findTop1ByOrderByIdDesc();
        if (top1ByOrderByIdDesc != null) {
            pageDto.setBestVariantOwner(String.valueOf(top1ByOrderByIdDesc.getEmail()));
            pageDto.setBestVariant(String.valueOf(top1ByOrderByIdDesc.getCurrentAnswer()));
            pageDto.setHistory(answerBoardRepository.findByIdLessThanOrderByIdDesc(top1ByOrderByIdDesc.getId()));
        }
    }

    private void plusOneToScore(String email){
        Score sessionScore = scoreRepository.findByEmail(email);
        sessionScore.setNumberScore(sessionScore.getNumberScore() + 1);
        //?scoreRepository.save(sessionScore);
    }
}