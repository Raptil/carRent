package net.carProject.service;

import net.carProject.domain.Car;
import net.carProject.domain.Transaction;
import net.carProject.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by Алексей on 28.05.2017.
 */
public interface TransactionService { // объяляем interface

    public void save( User userGuest,
                     Car car, Date dateStart, Date dateEnd); //  объявляем метод

    public boolean trueUser(Car car, User user);
}
