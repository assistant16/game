package Game;

import Game.controller.UserController;
import Game.entity.CurrentQuestion;
import Game.entity.Question;
import Game.entity.User;
import Game.repository.UserRepository;
import Game.service.Impl.CurrentQuestionServiceImpl;
import Game.service.Impl.MainServiceImpl;
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

	@Autowired
	MainServiceImpl mainServiceImpl;

//	@Autowired
//	CurrentQuestionServiceImpl currentQuestionService;


		@PostConstruct   //need to add at entity
		public void init() {

			//UserController userController = new UserController();
			questionServiceImpl.addQuestion(new Question("what's wrong?"));
			questionServiceImpl.addQuestion(new Question("what's else?"));
			questionServiceImpl.addQuestion(new Question("how r u?"));

			//currentQuestionService.addCurrentQuestion(new CurrentQuestion("what's wrong"));
			mainServiceImpl.begin();

		}

//
//	@Bean
//	CommandLineRunner runner(UserController userController){
//	    return args -> {
//			userController.addUser2(new User("vasya","vasya","vasya"));
//	};
//}


}
