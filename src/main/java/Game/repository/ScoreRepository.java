package Game.repository;

import Game.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    //@Query +

    Score findByEmail(String email);
    List<Score> findAllByOrderByNumberScoreDesc();
}
