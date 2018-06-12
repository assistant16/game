package Game.Service;

import Game.Entity.Question;

import java.util.List;


public interface QuestionService {
    Question addQuestion(Question question);
    List<Question> getAllQuestions();
    Question findByIdQuestion(int id);

}
