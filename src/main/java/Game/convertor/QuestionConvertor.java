package Game.convertor;

import Game.DTO.QuestionDto;
import Game.Entity.Question;

public interface QuestionConvertor {
    Question toQuestion(QuestionDto questionDto);
    QuestionDto toDtoQ(Question question);

}
