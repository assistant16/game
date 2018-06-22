package Game.repository;

import Game.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    Score findByName(String email);
}
