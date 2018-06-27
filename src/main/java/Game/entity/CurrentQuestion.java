package Game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CurrentQuestion {
    @Id
    private String currentQuestionName;
    private int currentAnswer;
    private boolean solved = false;
    private Date date;



    public Date getDate() {
        return date;
    }

    public void setDate(Date dataTime) {
        this.date = dataTime;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }


    public String getCurrentQuestionName() {
        return currentQuestionName;
    }

    public void setCurrentQuestionName(String currentQuestionName) {
        this.currentQuestionName = currentQuestionName;
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    @Override
    public String toString() {
        return "CurrentQuestion{" +
                "currentQuestionName='" + currentQuestionName + '\'' +
                ", currentAnswer=" + currentAnswer +
                ", solved=" + solved +
                ", date=" + date +
                '}';
    }
}
