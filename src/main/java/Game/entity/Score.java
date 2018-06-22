package Game.entity;

import javax.management.StandardEmitterMBean;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Score")
public class Score {

    @Id
    private String email;
    private int numberScore;

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

                Objects.equals(email, score.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash( numberScore, email);
    }

    @Override
    public String toString() {
        return "Score{" +
                ", numberScore=" + numberScore +
                ", email='" + email + '\'' +
                '}';
    }
}
