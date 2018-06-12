
package GamePuzzle.serviceTestIT.NewsService;

import Game.ApplicationTest;
import Game.Entity.User;
import Game.Service.UserService;
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

@SpringBootTest(classes = ApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@EnableAutoConfiguration
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AutoConfigureTestEntityManager
public class UserServiceTestIT extends BaseServiceTest {

    @Autowired
    protected TestEntityManager entityManager;
    @Autowired
    protected UserService userService;

    @Test
    public void TestExample1() throws Exception {
        User user = new User("tes432r2", "312","qwe");
        entityManager.persist(user);
        entityManager.flush();
        User found = userService.getByIdUser(user.getId()).orElseThrow(() -> new Exception());

        Assertions.assertEquals(found.getId(), user.getId());
    }

}