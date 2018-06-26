package Game.repository;

import Game.entity.AnswerBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerBoardRepository extends JpaRepository<AnswerBoard,Long> {
    AnswerBoard findLastBy();
    AnswerBoard findTop1ByOrderByIdDesc();
    List<AnswerBoard> findByIdLessThanOrderByIdDesc(long id);

}
