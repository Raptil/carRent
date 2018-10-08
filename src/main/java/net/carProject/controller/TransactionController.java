package net.carProject.controller;


import net.carProject.domain.Car;
import net.carProject.domain.User;
import net.carProject.service.CarService;
import net.carProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class TransactionController {

    @Autowired
    @Qualifier(value = "TransactionService")
    private TransactionService transactionService;

    @Autowired
    private CarService carService;

    private java.sql.Date strToDate(String str) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date date = null;
        try {
            date = new java.sql.Date(dateFormat.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @RequestMapping(value = "/bookIt/{carId}", method = RequestMethod.POST)
    public String bookIt(@PathVariable("carId") int carId,
                         @RequestParam("dateStart") String dateStr,
                         @RequestParam("dateEnd") String dateEn, HttpSession session) {
        User user = (User) session.getAttribute("user");
        java.sql.Date dateStart = strToDate(dateStr);
        java.sql.Date dateEnd = strToDate(dateEn);
        Car car = carService.getCarById(carId);
        transactionService.save(user, car, dateStart, dateEnd);
        return "/mainLogIn";
    }


}
