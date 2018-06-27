package Game.dto;

import Game.entity.AnswerBoard;
import Game.entity.Score;

import java.util.List;

public class PageDto {

    private String systemResponse;
    private String currentQuestion;
    private String bestVariant;
    private List<AnswerBoard> history;
    private String bestVariantOwner;
    private List<Score> top;   //or scoreDto?
    private int newGameDelay;
    private int answerDelay;

    public int getNewGameDelay() {
        return newGameDelay;
    }

    public void setNewGameDelay(int newGameDelay) {
        this.newGameDelay = newGameDelay;
    }

    public int getAnswerDelay() {
        return answerDelay;
    }

    public void setAnswerDelay(int answerDelay) {
        this.answerDelay = answerDelay;
    }

    public String getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(String currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public String getSystemResponse() {
        return systemResponse;
    }

    public void setSystemResponse(String systemResponse) {
        this.systemResponse = systemResponse;
    }

    public String getBestVariant() {
        return bestVariant;
    }

    public void setBestVariant(String bestVariant) {
        this.bestVariant = bestVariant;
    }

    public List<AnswerBoard> getHistory() {
        return history;
    }

    public void setHistory(List<AnswerBoard> history) {
        this.history = history;
    }

    public String getBestVariantOwner() {
        return bestVariantOwner;
    }

    public void setBestVariantOwner(String bestVariantOwner) {
        this.bestVariantOwner = bestVariantOwner;
    }

    public List<Score> getTop() {
        return top;
    }

    public void setTop(List<Score> top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "PageDto{" +
                "systemResponse='" + systemResponse + '\'' +
                ", bestVariant='" + bestVariant + '\'' +
                ", history=" + history +
                ", bestVariantOwner='" + bestVariantOwner + '\'' +
                ", top=" + top +
                '}';
    }
}
