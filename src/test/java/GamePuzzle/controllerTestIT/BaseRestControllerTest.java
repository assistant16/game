package GamePuzzle.controllerTestIT;

import Game.ApplicationTest;
import GamePuzzle.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@ContextConfiguration(classes = ApplicationTest.class)
public abstract class BaseRestControllerTest extends BaseTest {

    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;
}
