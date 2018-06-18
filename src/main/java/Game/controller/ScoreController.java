package Game.controller;

import Game.dto.ScoreDto;
import Game.entity.Score;
import Game.service.Impl.ScoreServiceImpl;
import Game.convertor.ScoreConvertor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    private ScoreServiceImpl scoreServiceImpl;

    private ScoreConvertor scoreConvertor;

    @PostMapping(name = "/addingScore")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreDto addUser(@RequestBody ScoreDto scoreDto) {
        Score score = scoreServiceImpl.addScore(scoreConvertor.toScore(scoreDto));
        return scoreConvertor.toDto(score);
    }

    @GetMapping(name = "/viewAllScore",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Score> getAllUsers(){
        return scoreServiceImpl.getAllScore();
    }

    @GetMapping(value = "scoreId/{scoreId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Score> getByIdUser(@PathVariable("scoreId") Long id){
        return scoreServiceImpl.getByIdScore(id);
    }
}
