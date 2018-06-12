package Game.Service.Impl;

import Game.Entity.Question;
import Game.Repository.QuestionRepository;
import Game.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    private QuestionRepository QuestionRepository;

    @Override
    public Question addQuestion(Question question) {
        return QuestionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
            questions.addAll(QuestionRepository.findAll());
        return questions;
    }


    @Override
    public Question findByIdQuestion(int id) {
        return entityManager.find(Question.class,id);//questionRepository.findById(id);
    }


}

