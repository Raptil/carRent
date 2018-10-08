package net.carProject.controller;


import net.carProject.domain.Car;
import net.carProject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = {"/", "/mainLogOut"}, method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        List<Car> cars = carService.getNewCars();
        List<Car> carsRec = carService.getRecNull();
        model.addAttribute("cars", cars);
        model.addAttribute("carsRec", carsRec);
        return "mainLogOut";
    }


}
