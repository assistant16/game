package Game.convertor.Impl;

import Game.dto.ScoreDto;
import Game.entity.Score;
import Game.convertor.ScoreConvertor;

public class ScoreConvertorImpl implements ScoreConvertor {
    @Override
    public ScoreDto toDto(Score score) {
       ScoreDto scoreDto = new ScoreDto();
       scoreDto.setName(score.getEmail());
       scoreDto.setScore(String.valueOf(score.getNumberScore()));

       return scoreDto;
    }

    @Override
    public Score toScore(ScoreDto scoreDto) {
        Score score = new Score();
        score.setNumberScore(Integer.parseInt(scoreDto.getScore()));
        score.setEmail(scoreDto.getName());
        return score;
    }
}
