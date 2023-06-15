package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.ItemTag;
import vision2cloud.argon.persistence.Impl.ItemTagImpl;

import java.util.List;

@Service("ItemTagService")
public class ItemTagService {
    @Autowired
    @Qualifier("ItemTagImpl")
    ItemTagImpl itemTagImpl;

    public Object create(ItemTag itemTag) {
        return itemTagImpl.create(itemTag);
    }

    public List<ItemTag> getItemsTags() {
        return itemTagImpl.getItemsTags();
    }

}
