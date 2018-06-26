//package GamePuzzle.controllerTestIT.NewsController;
//
//import Game.controller.UserController;
//import Game.entity.User;
//import Game.service.Impl.UserServiceImpl;
//import Game.convertor.UserConvertor;
//import GamePuzzle.controllerTestIT.BaseRestControllerTest;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//@WebMvcTest(UserController.class)
//public class UserControllerTestIT extends BaseRestControllerTest {
//
//    @MockBean
//    private UserConvertor userConverter;
//
//    @MockBean
//    private UserServiceImpl userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//        mvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//
//    @Test
//    public void addUserTest() throws Exception {
//        User MockUser = new User();
//        MockUser.setId(1L);
//        MockUser.setName("test");
//        MockUser.setPassword("test");
//        MockUser.setEmail("test");
//        //List<User> allusers = Arrays.asList(MockUser);
//
//        String inputInJson = this.mapToJson(MockUser);
//
//        String URL="/api/user/adding/";
//
//        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(MockUser);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post(URL)
//                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//
//        String outputInJson = response.getContentAsString();
//
//        assertThat(outputInJson).isEqualTo(inputInJson);
//        //assertEquals(HttpStatus.OK.value()),response.getStatus())
//
//        //given(this.userService.getByIdUser(1L));
//               // .willReturn(new User("test", "test","test"));
//
////        mvc.perform(get("/user")
////                .accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(content().json(objectMapper.writeValueAsString());
//    }
//
//    @Test
//    public void getAllUserTest() throws Exception {
//        User MockUser1 = new User("test1","test1","test1");
//        User MockUser2 = new User("test2","test2","test2");
//
//        List<User> userList = new ArrayList<>();
//        userList.add(MockUser1);
//        userList.add(MockUser2);
//
//       // String inputInJson = this.mapToJson(MockUser);
//
//        String URI="/api/user/viewAll";
//
//        Mockito.when(userService.getAllUsers()).thenReturn(userList);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mvc.perform(requestBuilder).andReturn();
//
//        String expectedJson = this.mapToJson(userList);
//        String outputInJson = result.getResponse().getContentAsString();
//
//        assertThat(outputInJson).isEqualTo(expectedJson);
//    }
//
//    @Test
//    public void getByIdUserTest() throws Exception {
//        User MockUser = new User();
//        MockUser.setId(1L);
//        MockUser.setName("test");
//        MockUser.setPassword("test");
//        MockUser.setEmail("test");
//
//
//        Mockito.when(userService.getByIdUser(Mockito.anyLong())).thenReturn(java.util.Optional.ofNullable(MockUser));
//
//        String URI="/api/user/userId/1";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .get(URI)
//                .accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mvc.perform(requestBuilder).andReturn();
//
//        String expectedJson = this.mapToJson(MockUser);
//        String outputInJson = result.getResponse().getContentAsString();
//
//        assertThat(outputInJson).isEqualTo(expectedJson);
//    }
//
//    public String mapToJson(Object object) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(object);
//    }
//}
//
//
//
////    final NewsProvider newsProvider = NewsProviderTestFactory.createWithId(PAPER_NEWS_PROVIDER_ID, CITY_ID,
////            FeedTestFactory.createPaperListWithId());
////    final List<NewsProvider> newsProviders = NewsProviderTestFactory.createListWithId(CITY_ID);
////    final Feed feed = FeedTestFactory.createWithId(DEFAULT_FEED_ID, PAPER_NEWS_PROVIDER_ID,
////            FeedTestFactory.LOCAL_FEED_URLs[new Random().nextInt(FeedTestFactory.LOCAL_FEED_URLs.length)]);
////    final NewsDetailsDTO detailsDTO = NewsTestFactory.createDetailsDTO(DEFAULT_NEWS_ITEM_ID);
////
////    given(feedService.findById(DEFAULT_FEED_ID)).willReturn(feed);
////    given(newsProviderService.findById(PAPER_NEWS_PROVIDER_ID)).willReturn(newsProvider);
////    given(newsProviderService.cityNewsProviders(CITY_ID)).willReturn(newsProviders);
////    given(newsConverter.toCityProvidersDetailsDTO(feed, DEFAULT_NEWS_ITEM_ID,
////          newsProvider,
////          newsProviders)).willReturn(detailsDTO);
////
////        mvc.perform(get("/news/" + DEFAULT_NEWS_ITEM_ID + "?feedId=" + DEFAULT_FEED_ID).accept(MediaType
////                                                                                                       .APPLICATION_JSON))
////            .andExpect(status().isOk())
////            .andExpect(content().json(objectMapper.writeValueAsString(detailsDTO)));
