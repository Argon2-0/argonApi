package vision2cloud.argon.persistence.zkt;

import vision2cloud.argon.model.zkt.Person;

import java.net.URISyntaxException;

public interface PersonPersistence {
    Object create(Person person) throws URISyntaxException;
    Object get(String pin) throws URISyntaxException;
}
