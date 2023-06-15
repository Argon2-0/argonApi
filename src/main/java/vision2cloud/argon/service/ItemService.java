package vision2cloud.argon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Item;
import vision2cloud.argon.persistence.Impl.ItemImpl;

import java.util.List;

@Service("ItemService")
public class ItemService {
    @Autowired
    @Qualifier("ItemImpl")
    ItemImpl itemImpl;

    public Object create(Item item) {
        return itemImpl.create(item);
    }

    public List<Item> getItems() {
        return itemImpl.getItems();
    }

    public Item getItemById(int id) {
        return itemImpl.getItemById(id);
    }

    public Object update(Item item) {
        return itemImpl.update(item);
    }
}
