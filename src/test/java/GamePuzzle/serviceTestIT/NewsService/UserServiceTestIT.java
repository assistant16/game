
package GamePuzzle.serviceTestIT.NewsService;

import Game.ApplicationTest;
import Game.entity.User;
import Game.service.Impl.UserServiceImpl;
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
public class UserServiceTestIT extends BaseServiceTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    protected UserServiceImpl userServiceImpl;

    @Test
    public void findByIdUserTest() throws Exception {
        User user = new User("tes432r2", "312", "qwe");
        entityManager.persist(user);
        entityManager.flush();
        User found = userServiceImpl.getByIdUser(user.getId()).orElseThrow(() -> new Exception());

        Assertions.assertEquals(found.getId(), user.getId());
    }

    @Test
    public void addUserTest() throws Exception {
        User firstUser = new User("test", "test", "test");
        User secondUser = new User("test2", "test2", "test2");
        userServiceImpl.addUser(firstUser);

        userServiceImpl.addUser(secondUser);

        User savedUser = this.entityManager.persistFlushFind(secondUser);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("test2");
        assertThat(savedUser.getPassword()).isEqualTo("test2");
        assertThat(savedUser.getEmail()).isEqualTo("test2");


    }
}