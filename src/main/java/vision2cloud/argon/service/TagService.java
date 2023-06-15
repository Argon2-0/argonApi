package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Tag;
import vision2cloud.argon.persistence.Impl.TagImpl;

import java.util.List;

@Service("TagService")
public class TagService {
    @Autowired
    @Qualifier("TagImpl")
    TagImpl tagImpl;

    public Object create(Tag tag) {
        return tagImpl.create(tag);
    }

    public List<Tag> getTags() {
        return tagImpl.getTags();
    }

    public Tag getTagById(long id) {
        return tagImpl.getTagById(id);
    }

    public Object update(Tag tag) {
        return tagImpl.update(tag);
    }
}
