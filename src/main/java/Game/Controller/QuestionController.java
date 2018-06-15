package Game.Controller;

import Game.Entity.Question;
import Game.Service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @RequestMapping("/addQ")
    public String addQ(@RequestParam String questionName, @RequestParam int answer) {
        questionServiceImpl.addQuestion(new Question(questionName,answer));
        return ("added");
    }

//    @GetMapping(value = "/RandomQ",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Question  showRandom(){
//
//    }

    @GetMapping(value = "/viewQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> showQ(){
        return questionServiceImpl.getAllQuestions();
    }

    @GetMapping("/findQ")
    public String getByIdQuestion(@RequestParam Long id){
        return questionServiceImpl.getByIdQuestion(id).toString();
    }

}
