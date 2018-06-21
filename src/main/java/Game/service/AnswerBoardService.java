package Game.service;

import Game.entity.AnswerBoard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface AnswerBoardService {
    List<AnswerBoard> getAllAnswerBoard();
}
