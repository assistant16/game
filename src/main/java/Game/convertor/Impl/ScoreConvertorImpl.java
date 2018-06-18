package Game.convertor.Impl;

import Game.dto.ScoreDto;
import Game.entity.Score;
import Game.convertor.ScoreConvertor;

public class ScoreConvertorImpl implements ScoreConvertor {
    @Override
    public ScoreDto toDto(Score score) {
       ScoreDto scoreDto = new ScoreDto();
       scoreDto.setId(score.getId());
       scoreDto.setNumberScore(score.getNumberScore());
       return scoreDto;
    }

    @Override
    public Score toScore(ScoreDto scoreDto) {
        Score score = new Score();
        score.setId(scoreDto.getId());
        score.setNumberScore(scoreDto.getNumberScore());
        return score;
    }
}
