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
	QuestionServiceImpl questionServiceImpl;


		@PostConstruct
		public void init() {

			//UserController userController = new UserController();
			userServiceImpl.addUser(new User( "vasya", "vasya", "vasya"));
			userServiceImpl.addUser(new User( "vasya2", "vasya2", "vasya2"));
			userServiceImpl.addUser(new User( "vasya3", "vasya3", "vasya3"));
			questionServiceImpl.addQuestion(new Question("what the fuck?",404));
			//userController.addUser(userConvertor.toDto(new User("petya","petya","petya")));

		}
//
//	@Bean
//	CommandLineRunner runner(QuestionRepository questionRepository){
//	    return args -> {
//			questionRepository.save(new Question("vasya",2));
//        };
//	}

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
