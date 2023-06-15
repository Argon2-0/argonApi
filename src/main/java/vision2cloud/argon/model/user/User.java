package vision2cloud.argon.model.user;

import vision2cloud.argon.model.Role;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
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
    @Column(name = "password")
    private String password;
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

    public User() {
    }

    public User(int id, String name, String email, Timestamp emailVerifiedAt, String password, String picture, Role role, String rememberToken, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailVerifiedAt = emailVerifiedAt;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", emailVerifiedAt=" + emailVerifiedAt +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", role_id=" + role +
                ", rememberToken=" + rememberToken +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
