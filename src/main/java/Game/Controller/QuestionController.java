package Game.Controller;

import Game.Entity.Question;
import Game.Service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    private QuestionServiceImpl questionServiceImpl;




    @RequestMapping("/addQ")
    public String addQ(@RequestParam String questionName, @RequestParam int answer) {
        questionServiceImpl.addQuestion(new Question(questionName,answer));
        return ("added");
    }

   // @RequestMapping("/showQ")
//    public String showQ(){
//        return questionServiceImpl.getAllQuestions().toString();
//    }

    @GetMapping("/findQ")
    public String getByIdQuestion(@RequestParam Long id){
        return questionServiceImpl.getByIdQuestion(id).toString();
    }

}
