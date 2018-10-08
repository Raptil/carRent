package net.carProject.service;

import net.carProject.domain.Car;
import net.carProject.domain.User;

import java.util.Date;


public interface TransactionService { // объяляем interface

    public void save(User userGuest,
                     Car car, Date dateStart, Date dateEnd); //  объявляем метод

    public boolean trueUser(Car car, User user);
}
