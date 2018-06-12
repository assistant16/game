package Game.Controller;

import Game.Entity.Question;
import Game.Service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {

    private QuestionServiceImpl questionServiceImpl;


    @RequestMapping("/addQ")
    public String addQ(@RequestParam String name, @RequestParam int answer) {
        questionServiceImpl.addQuestion(new Question(name,answer));
        return ("added");
    }

    @RequestMapping("/showQ")
    public String showQ(){
        return questionServiceImpl.getAllQuestions().toString();
    }

    @GetMapping("/findQ")
    public String findByIdQuestion(@RequestParam int id){
        return questionServiceImpl.findByIdQuestion(id).toString();
    }

}
