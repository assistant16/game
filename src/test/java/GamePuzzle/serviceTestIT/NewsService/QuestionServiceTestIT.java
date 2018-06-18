package GamePuzzle.serviceTestIT.NewsService;


import Game.ApplicationTest;
import Game.entity.Question;
import Game.service.Impl.QuestionServiceImpl;
import GamePuzzle.serviceTestIT.BaseServiceTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@EnableAutoConfiguration
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager
public class QuestionServiceTestIT extends BaseServiceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    protected QuestionServiceImpl questionServiceImpl;

    @Test
    public void getByIdQuestionTest() throws Exception {
        Question question = new Question("test",2);
        entityManager.persist(question);
        entityManager.flush();
        Question found = questionServiceImpl.getByIdQuestion(question.getId()).orElseThrow(() -> new Exception());

        Assertions.assertEquals(found.getId(), question.getId());
    }

    @Test
    public void addQuestionTest() {
        Question question1 = new Question("test1", 1);
        Question question2 = new Question("test2", 2);
        questionServiceImpl.addQuestion(question1);
        questionServiceImpl.addQuestion(question2);

        Question savedQuestion = this.entityManager.persistFlushFind(question1);

        assertThat(savedQuestion.getId()).isNotNull();
        assertThat(savedQuestion.getQuestion()).isEqualTo("test1");
        assertThat(savedQuestion.getAnswer()).isEqualTo(1);
    }
}

