package vision2cloud.argon.persistence.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.Item;
import vision2cloud.argon.persistence.ItemPersistence;
import vision2cloud.argon.repository.ItemRepository;

import java.util.List;

@Service("ItemImpl")
public class ItemImpl implements ItemPersistence {

    @Autowired
    @Qualifier("ItemRepository")
    ItemRepository itemRepository;

    @Override
    public Object create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Object update(Item item) {
        Item actualItem = getItemById(item.getId());
        actualItem.setName(item.getName());
        actualItem.setExcerpt(item.getExcerpt());
        actualItem.setDescription(item.getDescription());
        actualItem.setPicture(item.getPicture());
        actualItem.setCategory(item.getCategory());
        actualItem.setStatus(item.getStatus());
        actualItem.setDate(item.getDate());
        actualItem.setOptions(item.getOptions());
        actualItem.setupdatedAt(item.getupdatedAt());
        return itemRepository.save(actualItem);
    }
}
