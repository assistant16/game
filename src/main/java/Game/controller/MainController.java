package Game.controller;

import Game.dto.PageDto;
import Game.service.Impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class MainController {


        @Autowired
        private MainServiceImpl mainServiceImpl;

        @PostMapping(value = "/try")
        public PageDto guess(){
            return mainServiceImpl.guess(10,"vasya");
        }

        @GetMapping(value = "/show")
        public PageDto getPage(){
            return mainServiceImpl.getPage();
        }


}
