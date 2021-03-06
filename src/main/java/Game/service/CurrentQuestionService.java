package Game.service;

import Game.entity.CurrentQuestion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface CurrentQuestionService {
    CurrentQuestion addCurrentQuestion(CurrentQuestion question);
    List<CurrentQuestion> getAllCurrentQuestions();
}
