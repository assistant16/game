package Game.entity;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String questionName;


    public Question(){}

    public Question(String questionName, int answer) {
        this.questionName = questionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", question='" + questionName + '\'' +
                '}';
    }

}
