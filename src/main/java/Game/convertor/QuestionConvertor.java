package Game.convertor;

import Game.dto.QuestionDto;
import Game.entity.Question;

public interface QuestionConvertor {
    Question toQuestion(QuestionDto questionDto);
    QuestionDto toDtoQ(Question question);

}
