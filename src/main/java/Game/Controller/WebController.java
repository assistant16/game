package Game.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/")
public class WebController {

    @GetMapping("")
    public ModelAndView homepage(){
        return new ModelAndView("game.html");
    }

//    @GetMapping("")
//    public String homepage1(){
//        return "game.html";
//    }
}
