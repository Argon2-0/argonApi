package vision2cloud.argon.persistence;

import vision2cloud.argon.model.HistoryTipoServicio;
import vision2cloud.argon.model.Item;

import java.util.List;

public interface ItemPersistence {
    Object create(Item item);
    List<Item> getItems();
    Item getItemById(int id);
    Object update(Item item);
}
