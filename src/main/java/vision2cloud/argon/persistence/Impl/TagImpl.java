package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Tag;
import vision2cloud.argon.persistence.TagPersistence;
import vision2cloud.argon.repository.TagRepository;

import java.util.List;

@Service("TagImpl")
public class TagImpl implements TagPersistence {

    @Autowired
    @Qualifier("TagRepository")
    TagRepository tagRepository;

    @Override
    public Object create(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(long id) {
        return tagRepository.findById(Math.toIntExact(id)).get();
    }

    @Override
    public Object update(Tag tag) {
        Tag actualTagImpl = getTagById(tag.getId());
        actualTagImpl.setName(tag.getName());
        actualTagImpl.setColor(tag.getColor());
        actualTagImpl.setupdatedAt(tag.getupdatedAt());
        return tagRepository.save(actualTagImpl);
    }
}
