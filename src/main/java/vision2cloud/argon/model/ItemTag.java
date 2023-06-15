package vision2cloud.argon.model;

import javax.persistence.*;

@Entity
@Table(name = "item_tag")
public class ItemTag {
    @Id
    private int id;
    @ManyToOne
    private Item item;
    @ManyToOne
    private Tag tag;

    public ItemTag() {
    }

    public ItemTag(Item item, Tag tag) {
        this.item = item;
        this.tag = tag;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ItemTag{" +
                "item_id=" + item +
                ", tag_id=" + tag +
                '}';
    }
}
