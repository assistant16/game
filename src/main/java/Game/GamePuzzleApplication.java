package Game;

import Game.Controller.UserController;
import Game.DTO.UserDto;
import Game.Entity.Question;
import Game.Entity.User;
import Game.Repository.QuestionRepository;
import Game.Service.Impl.QuestionServiceImpl;
import Game.Service.Impl.UserServiceImpl;
import Game.Service.QuestionService;
import Game.Service.UserService;
import Game.convertor.Impl.UserConvertorImpl;
import Game.convertor.UserConvertor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class GamePuzzleApplication {


	public static void main(String[] args) {
		SpringApplication.run(GamePuzzleApplication.class, args);
	}


	//@Component
	//public class StartUpInit {
	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserController userController;

	UserConvertorImpl userConvertorImpl;

	@Autowired
	QuestionServiceImpl questionServiceImpl;


		@PostConstruct
		public void init() {

			//UserController userController = new UserController();
			userServiceImpl.addUser(new User( "user1", "user1", "user1"));
			userServiceImpl.addUser(new User( "user2", "user2", "user2"));
			userServiceImpl.addUser(new User( "user3", "user3", "user3"));
			questionServiceImpl.addQuestion(new Question("what's wrong?",404));

			User userP = new User("petya","petya","petya");
			userController.addUser2(userP);
			//userConvertorImpl.toDto(userP);
			//
			userServiceImpl.getAllUsers();

		}
//
//	@Bean
//	CommandLineRunner runner(UserController userController){
//	    return args -> {
//			userController.addUser2(new User("vasya","vasya","vasya"));
//	};
//}

//	@Bean
//	CommandLineRunner runner(QuestionServiceImpl questionService) {
//		return args -> {
//			questionService.addQuestion(new Question("vasya2", 3));
//		};
//    }



	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
