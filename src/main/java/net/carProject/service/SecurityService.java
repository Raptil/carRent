package net.carProject.service;


import net.carProject.domain.Car;
import net.carProject.domain.Statistics;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);


}
