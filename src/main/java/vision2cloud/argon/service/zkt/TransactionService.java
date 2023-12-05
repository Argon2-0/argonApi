package vision2cloud.argon.service.zkt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vision2cloud.argon.model.zkt.Transaction;
import vision2cloud.argon.persistence.Impl.zkt.PersonImpl;
import vision2cloud.argon.persistence.Impl.zkt.TransactionImpl;

import java.net.URISyntaxException;
import java.util.ArrayList;

@Service("TransactionService")
public class TransactionService {
    @Autowired
    @Qualifier("TransactionImpl")
    TransactionImpl transactionImpl;

    public ArrayList<Transaction> get(String initialDate, String endDate) throws URISyntaxException{
        ArrayList<Transaction> transactions = transactionImpl.get(initialDate, endDate);
        ArrayList<Transaction> transactionFilter = new ArrayList<>();
        for (Transaction transaction: transactions){
            if (transaction.getDeptName().equals("CPA")){
                transactionFilter.add(transaction);
            }
        }
        return transactionFilter;
    };

}
