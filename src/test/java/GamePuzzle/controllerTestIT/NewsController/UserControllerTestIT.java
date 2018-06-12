package GamePuzzle.controllerTestIT.NewsController;

import Game.Controller.UserController;
import Game.Service.Impl.UserServiceImpl;
import Game.convertor.UserConvertor;
import GamePuzzle.controllerTestIT.BaseRestControllerTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(UserController.class)
public class UserControllerTestIT extends BaseRestControllerTest {

    @MockBean
    private UserConvertor userConverter;

    @MockBean
    private UserServiceImpl userService;


    }