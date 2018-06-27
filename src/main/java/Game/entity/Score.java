package Game.entity;

import javax.management.StandardEmitterMBean;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Score")
public class Score {

    @Id
    private String email;
    private int numberScore;
    private Date dateAnswerGiven;

    public Date getDateAnswerGiven() {
        return dateAnswerGiven;
    }

    public void setDateAnswerGiven(Date dateAnswerGiven) {
        this.dateAnswerGiven = dateAnswerGiven;
    }

    public int getNumberScore() {
        return numberScore;
    }

    public void setNumberScore(int numberScore) {
        this.numberScore = numberScore;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Score{" +
                "email='" + email + '\'' +
                ", numberScore=" + numberScore +
                ", dateAnswerGiven=" + dateAnswerGiven +
                '}';
    }

}