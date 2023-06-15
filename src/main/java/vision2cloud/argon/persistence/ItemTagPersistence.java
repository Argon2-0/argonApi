package vision2cloud.argon.persistence;

import vision2cloud.argon.model.Item;
import vision2cloud.argon.model.ItemTag;

import java.util.List;

public interface ItemTagPersistence {
    Object create(ItemTag itemTag);
    List<ItemTag> getItemsTags();
}
