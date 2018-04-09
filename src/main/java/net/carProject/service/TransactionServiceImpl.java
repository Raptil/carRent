package net.carProject.service;

import net.carProject.dao.TransactionDao;
import net.carProject.domain.Car;
import net.carProject.domain.Transaction;
import net.carProject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("TransactionService") //  объявление, что это слой Service с явным заданием имени
public class TransactionServiceImpl implements TransactionService{ //  расширяем интерфейс

    @Autowired // подключаем Dao слой
    private TransactionDao transactionDao;

    @Override // переопределение метода
    public void save( User userGuest, Car car, Date dateStart, Date dateEnd) {
        Transaction transaction= new Transaction();// создание новой сущности
        transaction.setCar(car);
        transaction.setDayStart(dateStart);
        transaction.setDayEnd(dateEnd);
        transaction.setRenter(userGuest);// заполнение сущности
        transactionDao.save(transaction); // использование работы с базой данных
    }

    @Override
    public boolean trueUser(Car car, User user) {
        boolean result = false;
        List<Transaction> transactionList = transactionDao.readAll();
        for (Transaction transaction:transactionList)
            if (transaction.getCar().equals(car) && transaction.getRenter().equals(user))
                result=true;
        return result;
    }
}
