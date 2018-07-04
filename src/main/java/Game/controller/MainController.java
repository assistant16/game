package Game.controller;

import Game.dto.PageDto;
import Game.service.Impl.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class MainController {

        HttpSession session;


        @Autowired
        private MainServiceImpl mainServiceImpl;

        @GetMapping(value = "/try")
        public PageDto guess(int variant,Principal user){
            OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) user ;
            Map<String,Object> details = authentication.getPrincipal().getAttributes();
        //String email = String.valueOf(details.get("email"));
            //check email
            return mainServiceImpl.guess(variant, String.valueOf(details.get("email")));
        }

        @GetMapping(value = "/show")
        public PageDto getPage(HttpSession session){
            return mainServiceImpl.getPage(session);
        }


}
