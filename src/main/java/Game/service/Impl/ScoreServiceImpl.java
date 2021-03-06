package Game.service.Impl;

import Game.entity.Score;
import Game.repository.ScoreRepository;
import Game.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ScoreServiceImpl implements ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score addScore(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> getAllScore() {
        return scoreRepository.findAll();
    }

    @Override
    public Optional<Score> getByIdScore(Long id) {
        return scoreRepository.findById(id);
    }


}
