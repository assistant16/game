package Game.service;

import Game.entity.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface QuestionService{
    Question addQuestion(Question question);
    List<Question> getAllQuestions();
    Optional<Question> getByIdQuestion(Long id);

}