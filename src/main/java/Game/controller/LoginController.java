package Game.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class LoginController {



    @GetMapping(value = "/user")
    public Principal user(Principal principal) {

        return principal;
    }

    @GetMapping(value = "/get",produces = MediaType.APPLICATION_JSON_VALUE)         //there is one question ?
    public String showEmail(Principal principal){
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) principal;
        Map<String,Object> details = authentication.getPrincipal().getAttributes();
        String email = String.valueOf(details.get("email"));
        return email;
    }
}