package Game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnswerBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private int currentAnswer;

    public AnswerBoard(){}

    public AnswerBoard(String email, int currentAnswer) {
        this.email = email;
        this.currentAnswer = currentAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(int currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    @Override
    public String toString() {
        return "AnswerBoard{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", currentAnswer=" + currentAnswer +
                '}';
    }
}
