package Game.convertor;

import Game.dto.ScoreDto;
import Game.entity.Score;

public interface ScoreConvertor {
    ScoreDto toDto(Score score);
    Score toScore(ScoreDto scoreDto);
}
