package Game.repository;

import Game.entity.AnswerBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerBoardRepository extends JpaRepository<AnswerBoard,Long> {
    AnswerBoard findLastById();
}
