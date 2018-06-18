package Game.service;

import Game.entity.Score;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ScoreService {
    Score addScore(Score score);
    List<Score> getAllScore();
    Optional<Score> getByIdScore(Long id);
}
