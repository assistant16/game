package Game.entity;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    private String questionName;

    public Question(){}

    public Question(String questionName, int answer) {
        this.questionName = questionName;
    }

    public String getQuestion() {
        return questionName;
    }

    public void setQuestion(String questionName) {
        this.questionName = questionName;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                ", question='" + questionName + '\'' +
                '}';
    }

}
