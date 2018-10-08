package net.carProject.dao;

import net.carProject.domain.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDao extends CRUDImpl<Transaction> {

    public TransactionDao() {
        super(Transaction.class);
    }
}
