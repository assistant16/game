package Game.service.Impl;

import Game.entity.CurrentQuestion;
import Game.repository.CurrentQuestionRepository;
import Game.service.CurrentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CurrentQuestionServiceImpl implements CurrentQuestionService{

    @Autowired
    private CurrentQuestionRepository currentQuestionRepository;


    @Override
    public CurrentQuestion addCurrentQuestion(CurrentQuestion question) {
        return currentQuestionRepository.save(question);
    }

    @Override
    public List<CurrentQuestion> getAllCurrentQuestions() {
        return currentQuestionRepository.findAll();
    }
}
