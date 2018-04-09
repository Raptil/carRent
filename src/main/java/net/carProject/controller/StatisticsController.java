package net.carProject.controller;


import net.carProject.domain.Car;
import net.carProject.domain.Statistics;
import net.carProject.domain.User;
import net.carProject.service.CarService;
import net.carProject.service.StatisticsService;
import net.carProject.service.TransactionService;
import net.carProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller// объявляем , что это Controller
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;



    @RequestMapping(value = "/statisticsAdd/{carId}",method = RequestMethod.POST)// создаем запрос с методом POST
    public String addStatistics(@PathVariable("carId") int carId, // считываем id
                                @ModelAttribute("message") String message, // сообщение, если пользователь не брал в аренду транспорт
                                HttpSession session, @ModelAttribute("statistics") Statistics statistics){ // считываем сессию и загруженный атрибут
        if (message!=null){
            return "redirect:/car/{carId}";  // пользователь не сможет добавить статистические данные, если не брал в аренду транспорт
        }
        User user = (User) session.getAttribute("user");
        Car car = carService.getCarById(carId);
        statistics.setCar(car);
        statisticsService.save(statistics);
        user.setPointsUser(user.getPointsUser()+1);
        userService.changeProfile(user);
        car.setPointsCar(car.getPointsCar()+1);
        carService.changeCar(car);
        return "redirect:/car/{carId}"; // переходим на страницу транспорта
    }
}
