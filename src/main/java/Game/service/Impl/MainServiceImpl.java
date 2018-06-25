package Game.service.Impl;

import Game.dto.PageDto;
import Game.dto.ScoreDto;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
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



    @Override
    public PageDto guess(int variant,String email) {
        this.getPage();
        PageDto pageDto = new PageDto();

        String systemResponse;
        AnswerBoard bestVariant = answerBoardRepository.findTop1ByOrderByIdDesc();
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();

        int bestNumber;
        if (bestVariant != null) { bestNumber = bestVariant.getCurrentAnswer();
        } else { bestNumber = variant;
        }
        int answer = currentQuestion.getCurrentAnswer();




        if(variant == answer){
            systemResponse = "win";
            //w somethind datatime
            Random random = new Random();
            Question question = questionRepository.findFirstBy();             //need random
            String newQuestion = question.getQuestion();

            currentQuestion.setSolved(true);
            Score sessionScoreCheck = scoreRepository.findByEmail(email);

            if(sessionScoreCheck == null ) {
                Score score = new Score();
                score.setEmail(email);
                score.setNumberScore(0);
                scoreRepository.save(score);
            }
            Score sessionScore = scoreRepository.findByEmail(email);

            sessionScore.setNumberScore(sessionScore.getNumberScore()+1);
            scoreRepository.save(sessionScore);
            currentQuestionRepository.delete(currentQuestionRepository.findFirstBy());
            answerBoardRepository.deleteAll();
            pageDto.setBestVariant(String.valueOf(variant));
            pageDto.setBestVariantOwner(email);
            CurrentQuestion newQuestionForSave = new CurrentQuestion();
            newQuestionForSave.setCurrentQuestionName(newQuestion);
            newQuestionForSave.setCurrentAnswer(random.nextInt(100));
            newQuestionForSave.setSolved(false);
            currentQuestionRepository.save(newQuestionForSave);
            bestNumber = variant;

        } else {
            if (Math.abs(variant - answer) <= Math.abs(bestNumber - answer)) {
                AnswerBoard newAnswerBoard = new AnswerBoard();
                bestNumber=variant;

                newAnswerBoard.setCurrentAnswer(variant);
                newAnswerBoard.setEmail(email);


                answerBoardRepository.save(newAnswerBoard);

                systemResponse = "It's better";
            } else {
                systemResponse = "It's worse";
            }
        }


        CheckAnswerBoard(pageDto);
        pageDto.setSystemResponse(systemResponse);
        pageDto.setCurrentQuestion(currentQuestionRepository.findFirstBy().getCurrentQuestionName());//currentQuestion.getCurrentQuestionName());

        pageDto.setTop(scoreRepository.findAll());

        return pageDto;

    }

    public  PageDto CheckAnswerBoard(PageDto pageDto){
        public Iterable<PageDto> findAll(
                @Spec(path = "firstName", spec = Like.class) Specification<Customer> spec) {

            return customerRepo.findAll(spec);
        }

        if(answerBoardRepository.findTop1ByOrderByIdDesc()!= null){
            pageDto.setBestVariant(String.valueOf(answerBoardRepository.findTop1ByOrderByIdDesc().getCurrentAnswer()));
            pageDto.setBestVariantOwner(String.valueOf(answerBoardRepository.findTop1ByOrderByIdDesc().getEmail()));
            AnswerBoard answerBoard = answerBoardRepository.findTop1ByOrderByIdDesc();
            answerBoardRepository.delete(answerBoardRepository.findTop1ByOrderByIdDesc());
            pageDto.setHistory(answerBoardRepository.findAll());
            answerBoardRepository.save(answerBoard);
        }
        return pageDto;
    }

    @Override
    public PageDto getPage() {
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstBy();

        PageDto pageDto = new PageDto();
        CheckAnswerBoard(pageDto);

        pageDto.setCurrentQuestion(currentQuestion.getCurrentQuestionName());
        pageDto.setTop(scoreRepository.findAll());


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
