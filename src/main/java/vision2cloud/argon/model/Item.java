package vision2cloud.argon.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "excerpt")
    private String excerpt;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;
    @ManyToOne
    private Categorie category;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private Date date;
    @Column(name = "showOnHomepage")
    private int showOnHomepage;
    @Column(name = "options")
    private String options;
    @Column(name = "createdAt")
    private Timestamp createdAt;
    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    public Item() {
    }

    public Item(int id, String name, String excerpt, String description, String picture, Categorie category, String status, Date date, int showOnHomepage, String options, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.excerpt = excerpt;
        this.description = description;
        this.picture = picture;
        this.category = category;
        this.status = status;
        this.date = date;
        this.showOnHomepage = showOnHomepage;
        this.options = options;
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

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Categorie getCategory() {
        return category;
    }

    public void setCategory(Categorie category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getshowOnHomepage() {
        return showOnHomepage;
    }

    public void setshowOnHomepage(int showOnHomepage) {
        this.showOnHomepage = showOnHomepage;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
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
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", excerpt='" + excerpt + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", category_id=" + category +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", showOnHomepage=" + showOnHomepage +
                ", options='" + options + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
