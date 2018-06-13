package Game.Service.Impl;

import Game.Entity.Score;
import Game.Repository.ScoreRepository;
import Game.Service.ScoreService;
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
