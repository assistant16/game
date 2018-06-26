package Game;

import Game.entity.Question;
import Game.service.Impl.MainServiceImpl;
import Game.service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
