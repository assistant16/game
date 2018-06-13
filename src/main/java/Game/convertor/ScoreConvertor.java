package Game.convertor;

import Game.DTO.ScoreDto;
import Game.Entity.Score;

public interface ScoreConvertor {
    ScoreDto toDto(Score score);
    Score toScore(ScoreDto scoreDto);
}
