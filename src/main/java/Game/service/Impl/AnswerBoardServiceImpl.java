package Game.service.Impl;

import Game.entity.AnswerBoard;
import Game.repository.AnswerBoardRepository;
import Game.service.AnswerBoardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnswerBoardServiceImpl implements AnswerBoardService{

    @Autowired
    private AnswerBoardRepository answerBoardRepository;

    @Override
    public List<AnswerBoard> getAllAnswerBoard() {
        return answerBoardRepository.findAll();
    }
}
