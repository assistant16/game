package GamePuzzle.serviceTestIT;

import Game.ApplicationTest;
import GamePuzzle.BaseTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationTest.class)
public abstract class BaseServiceTest extends BaseTest {

}