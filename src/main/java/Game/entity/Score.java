package Game.entity;

import javax.management.StandardEmitterMBean;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int numberScore;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return numberScore == score.numberScore &&
                Objects.equals(id, score.id) &&
                Objects.equals(email, score.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, numberScore, email);
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", numberScore=" + numberScore +
                ", email='" + email + '\'' +
                '}';
    }
}
