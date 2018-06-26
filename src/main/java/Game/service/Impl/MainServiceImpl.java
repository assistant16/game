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

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class MainServiceImpl implements MainService {

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
    public PageDto guess(int variant, String email) {
        this.getPage();
        PageDto pageDto = new PageDto();

        String systemResponse;
        AnswerBoard bestVariant = answerBoardRepository.findTop1ByOrderByIdDesc();
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();
        int FirstNumberFlag = 1;

        int bestNumber;
        if (bestVariant != null) {
            bestNumber = bestVariant.getCurrentAnswer();

        } else {
            bestNumber = variant;
            FirstNumberFlag = 0;
        }
        int answer = currentQuestion.getCurrentAnswer();

        if (variant == answer) {
            systemResponse = "win";
            //w somethind datatime
            Random random = new Random();

            List<Question> questions = questionRepository.findAll();
            Collections.shuffle(questions);
            Question question = questions.get(0);


            String newQuestion = question.getQuestion();

            currentQuestion.setSolved(true);
            Score sessionScoreCheck = scoreRepository.findByEmail(email);

            if (sessionScoreCheck == null) {
                Score score = new Score();
                score.setEmail(email);
                score.setNumberScore(0);
                scoreRepository.save(score);
            }
//            Timer gameTimer = new Timer();
//            gameTimer.scheduleAtFixedRate(new TimerTask() {
//                @Override
//                public void run() {
//
//                }
//            });

                Score sessionScore = scoreRepository.findByEmail(email);
                sessionScore.setNumberScore(sessionScore.getNumberScore() + 1);
                scoreRepository.save(sessionScore);
                currentQuestionRepository.delete(currentQuestionRepository.findFirstBy());
                answerBoardRepository.deleteAll();
                pageDto.setBestVariant(String.valueOf(variant));
                pageDto.setBestVariantOwner(email);
                CurrentQuestion newQuestionForSave = new CurrentQuestion();
                newQuestionForSave.setCurrentQuestionName(newQuestion);
                newQuestionForSave.setCurrentAnswer(random.nextInt(3));
                newQuestionForSave.setSolved(false);
                currentQuestionRepository.save(newQuestionForSave);
                bestNumber = variant;
                FirstNumberFlag = 0;

                sessions.broadcast("refresh");


            } else {
                if (Math.abs(variant - answer) == Math.abs(bestNumber - answer) && (FirstNumberFlag == 0)) {   //need to replace
                    AnswerBoard newAnswerBoard = new AnswerBoard();
                    newAnswerBoard.setCurrentAnswer(variant);
                    newAnswerBoard.setEmail(email);
                    FirstNumberFlag = 1;
                    answerBoardRepository.save(newAnswerBoard);
                    sessions.broadcast("refresh");
                    systemResponse = "Great begin";
                } else {
                    if (Math.abs(variant - answer) < Math.abs(bestNumber - answer)) {
                        AnswerBoard newAnswerBoard = new AnswerBoard();
                        bestNumber = variant;
                        newAnswerBoard.setCurrentAnswer(variant);
                        newAnswerBoard.setEmail(email);
                        answerBoardRepository.save(newAnswerBoard);
                        sessions.broadcast("refresh");
                        systemResponse = "It's better";
                    } else {
                        systemResponse = "It's worse";
                    }
                }
            }

            prepareAnswerBoard(pageDto);
            pageDto.setSystemResponse(systemResponse);
            pageDto.setCurrentQuestion(currentQuestionRepository.findFirstBy().getCurrentQuestionName());
            pageDto.setTop(scoreRepository.findAllByOrderByNumberScoreDesc());

            return pageDto;
        }




    public void prepareAnswerBoard(PageDto pageDto) {
        if (answerBoardRepository.findTop1ByOrderByIdDesc() != null) {
            pageDto.setBestVariantOwner(String.valueOf(answerBoardRepository.findTop1ByOrderByIdDesc().getEmail()));
            pageDto.setBestVariant(String.valueOf(answerBoardRepository.findTop1ByOrderByIdDesc().getCurrentAnswer()));
            pageDto.setHistory(answerBoardRepository.findByIdLessThanOrderByIdDesc(answerBoardRepository.findTop1ByOrderByIdDesc().getId()));
        }
    }

    @Override
    public PageDto getPage() {
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();

        PageDto pageDto = new PageDto();
        prepareAnswerBoard(pageDto);
        pageDto.setCurrentQuestion(currentQuestion.getCurrentQuestionName());
        pageDto.setTop(scoreRepository.findAllByOrderByNumberScoreDesc());
        return pageDto;
    }

    @Override
    public void begin() {

        CurrentQuestion forCheck = currentQuestionRepository.findFirstBy();
        Question firstBy = questionRepository.findFirstBy();   //need random

        if (forCheck == null || (!forCheck.isSolved())) {
            CurrentQuestion currentQuestion = new CurrentQuestion();

            currentQuestion.setCurrentQuestionName(firstBy.getQuestion());
            Random random = new Random();
            currentQuestion.setCurrentAnswer(random.nextInt(100));
            currentQuestion.setSolved(false);
            currentQuestionRepository.save(currentQuestion);
        }
    }
}
