package Game.convertor.Impl;

import Game.dto.QuestionDto;
import Game.entity.Question;
import Game.convertor.QuestionConvertor;

public class QuestionConvertorImpl implements QuestionConvertor{

    public QuestionConvertorImpl(){}


    @Override
    public QuestionDto toDtoQ(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setAnswer(question.getAnswer());
        questionDto.setQuestion(question.getQuestion());
        return questionDto;
    }


    @Override
    public Question toQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setAnswer(questionDto.getAnswer());
        question.setQuestion(questionDto.getQuestion());
        return question;
    }
}
