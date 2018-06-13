package Game.Service.Impl;

import Game.Entity.Question;
import Game.Repository.QuestionRepository;
import Game.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository QuestionRepository;

    @Override
    @Transactional
    public Question addQuestion(Question question) {
        return QuestionRepository.save(question);
    }

    @Override
    @Transactional
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
            questions.addAll(QuestionRepository.findAll());
        return questions;
    }


    @Override
    @Transactional
    public Optional<Question> getByIdQuestion(Long id) {
        return QuestionRepository.findById(id);
    }


}

