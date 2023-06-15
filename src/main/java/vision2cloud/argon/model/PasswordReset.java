package vision2cloud.argon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "password_resets")
public class PasswordReset {

    @Id
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Column(name = "createdAt")
    private Timestamp createdAt;

    public PasswordReset() {
    }

    public PasswordReset(String email, String token, Timestamp createdAt) {
        this.email = email;
        this.token = token;
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "PasswordReset{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
