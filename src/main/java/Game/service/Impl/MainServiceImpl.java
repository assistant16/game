package Game.service.Impl;

import Game.dto.PageDto;
import Game.dto.ScoreDto;
import Game.entity.AnswerBoard;
import Game.entity.CurrentQuestion;
import Game.entity.Score;
import Game.repository.AnswerBoardRepository;
import Game.repository.CurrentQuestionRepository;
import Game.repository.QuestionRepository;
import Game.repository.ScoreRepository;
import Game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    MainServiceImpl mainService;


    @Override
    public PageDto guess(int variant,String email) {
        mainService.getPage();
        String systemResponse;
        AnswerBoard bestVariant = answerBoardRepository.findLastById();
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstById();
        int bestNumber = bestVariant.getCurrentAnswer();
        int answer = currentQuestion.getCurrentAnswer();


        Score sessionScore = scoreRepository.findByName(email);


        if(variant == answer){
            systemResponse = "win";
            //w somethind datatime
            final Random random = new Random();
            String newQuestion = questionRepository.findRandom().getQuestion();
           // String newQuestion = questionRepository.findById(1L);

            currentQuestion.setSolved(true);

            sessionScore.setNumberScore(sessionScore.getNumberScore()+1);

            currentQuestionRepository.deleteAll();

            answerBoardRepository.deleteAll();
            answerBoardRepository.save(new AnswerBoard(email,answer));

            CurrentQuestion newQuestionForSave = new CurrentQuestion();
            newQuestionForSave.setCurrentQuestionName(newQuestion);
            newQuestionForSave.setCurrentAnswer(random.nextInt(3));
            newQuestionForSave.setSolved(false);
            currentQuestionRepository.save(newQuestionForSave);

        } else {
            if (Math.abs(variant - answer) < Math.abs(bestNumber - answer)) {
                AnswerBoard newAnswerBoard = new AnswerBoard();
                newAnswerBoard.setCurrentAnswer(variant);
                newAnswerBoard.setEmail(email);
                answerBoardRepository.save(newAnswerBoard);
                systemResponse = "yes";
            } else {
                systemResponse = "no";
            }
        }


        PageDto pageDto = new PageDto();
        pageDto.setSystemResponse(systemResponse);
        pageDto.setCurrentQuestion(currentQuestion.getCurrentQuestionName());
        pageDto.setBestVariantOwner(email);
        pageDto.setBestVariant(String.valueOf(bestNumber));
        pageDto.setHistory(answerBoardRepository.findAll());
        pageDto.setTop(scoreRepository.findAll());

        return pageDto;

    }

    @Override
    public PageDto getPage() {
        CurrentQuestion currentQuestion = currentQuestionRepository.findFirstById();
        if(!currentQuestion.isSolved())
        {
            List<AnswerBoard> allVariants = answerBoardRepository.findAll();
        }
        PageDto pageDto = new PageDto();
        pageDto.setCurrentQuestion(currentQuestion.getCurrentQuestionName());
        pageDto.setHistory(answerBoardRepository.findAll());
        pageDto.setTop(scoreRepository.findAll());

        return pageDto;
    }
}
