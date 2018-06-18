package Game.service.Impl;

import Game.entity.Question;
import Game.repository.QuestionRepository;
import Game.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return QuestionRepository.findAll();
    }


    @Override
    @Transactional
    public Optional<Question> getByIdQuestion(Long id) {
        return QuestionRepository.findById(id);
    }


}

