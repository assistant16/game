package Game.repository;


import Game.entity.CurrentQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentQuestionRepository extends JpaRepository<CurrentQuestion,Long> {
    CurrentQuestion findFirstBy();
}
