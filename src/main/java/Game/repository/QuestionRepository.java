package Game.repository;

import Game.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

    @Query(value="SELECT * FROM Question ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Question findRandom();


}
