package vision2cloud.argon.persistence.zkt;

import vision2cloud.argon.model.zkt.Transaction;

import java.net.URISyntaxException;
import java.util.ArrayList;

public interface TransactionPersistence {
    ArrayList<Transaction> get(String personPin, String initalDate, String endDate) throws URISyntaxException;
}
