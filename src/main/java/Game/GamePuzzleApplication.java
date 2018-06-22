package Game;

import Game.controller.UserController;
import Game.entity.Question;
import Game.entity.User;
import Game.repository.UserRepository;
import Game.service.Impl.QuestionServiceImpl;
import Game.service.Impl.UserServiceImpl;
import Game.convertor.Impl.UserConvertorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import javax.annotation.PostConstruct;



@SpringBootApplication

public class GamePuzzleApplication {


	public static void main(String[] args) {
		SpringApplication.run(GamePuzzleApplication.class, args);
	}

//	@Autowired
//	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception {
//		builder.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//				return newrepository.findById(s);
//			}
//		});
//	}
	//@Component
	//public class StartUpInit {
	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserController userController;

	UserConvertorImpl userConvertorImpl;

	@Autowired
	QuestionServiceImpl questionServiceImpl;


		@PostConstruct   //need to add at entity
		public void init() {

			//UserController userController = new UserController();
			questionServiceImpl.addQuestion(new Question("what's wrong?",404));
			questionServiceImpl.addQuestion(new Question("what's else?",909));
			questionServiceImpl.addQuestion(new Question("how r u?",49));

//			userServiceImpl.addUser(new User( "user1", "user1", "user1"));
//			userServiceImpl.addUser(new User( "user2", "user2", "user2"));
//			userServiceImpl.addUser(new User( "user3", "user3", "user3"));
//
//
//			User userP = new User("petya","petya","petya");
//			userController.addUser2(userP);
//			userConvertorImpl.toDto(userP);
//
//			userServiceImpl.getAllUsers();

		}
//
//	@Bean
//	CommandLineRunner runner(UserController userController){
//	    return args -> {
//			userController.addUser2(new User("vasya","vasya","vasya"));
//	};
//}


}
