package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Role;
import vision2cloud.argon.model.Tag;

import java.util.List;

public interface TagPersistence {
    Object create(Tag tag);
    List<Tag> getTags();
    Tag getTagById(long id);
    Object update(Tag tag);
}
