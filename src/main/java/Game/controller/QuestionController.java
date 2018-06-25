package Game.controller;

import Game.entity.Question;
import Game.service.Impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SAAJResult;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionServiceImpl;

    @RequestMapping("/addQ")
    public String addQ(@RequestParam String questionName, @RequestParam int answer) {
        questionServiceImpl.addQuestion(new Question(questionName));
        return ("added");
    }

    @GetMapping(value = "/RandomQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Question>  showRandom(){
        int coutOfQuestions = 3;
        return getByIdQuestion(1L + (long)(Math.random() * coutOfQuestions));
    }

    @GetMapping(value = "/viewQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> showQ(){
        return questionServiceImpl.getAllQuestions();
    }

    @GetMapping(value = "/winQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public String winQ() {
        return ("u won");
    }

    @GetMapping(value = "/tryQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public String tryQ(){
        return ("Try one more time");
    }

    @GetMapping(value = "/wtf",produces = MediaType.APPLICATION_JSON_VALUE)
    public String showAnswer(@RequestParam String answer){
        return (answer);
    }

    @GetMapping(value = "/winOrTryQ",produces = MediaType.APPLICATION_JSON_VALUE)
    public String showAnswer(@RequestBody int answer,int localAnswer){
        if (answer == localAnswer) {return ("u won");}
        else return ("Try more");
    }



    @GetMapping(value = "/questionId/{Id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Question> getByIdQuestion(@PathVariable("Id") Long id){
        return questionServiceImpl.getByIdQuestion(id);
    }

}
