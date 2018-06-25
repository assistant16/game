package Game.service;

import Game.dto.PageDto;

public interface MainService {
    PageDto guess(int answer,String email);
    PageDto getPage();
    void begin();
}
