package vision2cloud.argon.model.user;

import vision2cloud.argon.model.Role;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "emailVerifiedAt")
    private Timestamp emailVerifiedAt;
    @Column(name = "picture")
    private String picture;
    @ManyToOne
    private Role role;
    @Column(name = "rememberToken")
    private String rememberToken;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public UserInfo() {
    }

    public UserInfo(int id, String name, String email, Timestamp emailVerifiedAt, String picture, Role role, String rememberToken, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerifiedAt = emailVerifiedAt;
        this.picture = picture;
        this.role = role;
        this.rememberToken = rememberToken;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getemailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setemailVerifiedAt(Timestamp emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getrememberToken() {
        return rememberToken;
    }

    public void setrememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Timestamp getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emailVerifiedAt=" + emailVerifiedAt + '\'' +
                ", picture='" + picture + '\'' +
                ", role_id=" + role +
                ", rememberToken=" + rememberToken +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
