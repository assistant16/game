package Game.service;

import Game.dto.PageDto;

import javax.servlet.http.HttpSession;

public interface MainService {
    PageDto guess(int answer,String email);
    PageDto getPage(HttpSession session);
    void begin();
}
