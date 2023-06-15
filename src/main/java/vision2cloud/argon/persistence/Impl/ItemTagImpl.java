package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.ItemTag;
import vision2cloud.argon.persistence.ItemTagPersistence;
import vision2cloud.argon.repository.ItemTagRepository;

import java.util.List;

@Service("ItemTagImpl")
public class ItemTagImpl implements ItemTagPersistence {

    @Autowired
    @Qualifier("ItemTagRepository")
    ItemTagRepository itemTagRepository;

    @Override
    public Object create(ItemTag itemTag) {
        return itemTagRepository.save(itemTag);
    }

    @Override
    public List<ItemTag> getItemsTags() {
        return itemTagRepository.findAll();
    }

}
