package net.carProject.controller;


import net.carProject.controller.form.CarFilter;
import net.carProject.domain.Car;
import net.carProject.domain.Comment;
import net.carProject.domain.Statistics;
import net.carProject.domain.User;
import net.carProject.service.CarService;
import net.carProject.service.CommentService;
import net.carProject.service.StatisticsService;
import net.carProject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    @Qualifier(value = "CarService")
    private CarService carService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/newCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car, HttpSession session) {
        User user = (User) session.getAttribute("user");
        car.setOwner(user);
        carService.save(car);
        return "/mainLogIn";
    }

    @RequestMapping(value = "/newCar", method = RequestMethod.GET)
    public String carList(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "newCar";
    }

    @RequestMapping(value = {"/searchLogOut", "/searchLogIn"}, method = RequestMethod.GET)
    public String getCars(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        CarFilter carFilter = new CarFilter();
        model.addAttribute("carFilter", carFilter);
        if (user != null)
            return "/searchLogIn";
        else
            return "/searchLogOut";
    }

    @RequestMapping(value = {"/searchLogOut/search", "/searchLogIn/search"}, method = RequestMethod.GET)
    public String getFilteredCars(@ModelAttribute("carFilter") CarFilter carFilter, ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Car> cars;
        cars = carService.filterCar(carFilter.getCity(), carFilter.getMinPrice(), carFilter.getMaxPrice(),
                carFilter.getModel(), carFilter.getBodyType(), carFilter.getMinFuel(),
                carFilter.getMaxFuel());

        model.addAttribute("cars", cars);
        model.addAttribute("carFilter", carFilter);
        if (user != null)
            return "/searchLogIn";
        else
            return "/searchLogOut";
    }

    @RequestMapping(value = "/car/{carId}", method = RequestMethod.GET)
    public String getCar(@PathVariable("carId") int carId, ModelMap model,
                         HttpSession session) {
        User user = (User) session.getAttribute("user");
        Car car = carService.getCarById(carId);
        List<Comment> comments = commentService.getCommentByCarId(carId);
        model.addAttribute("comments", comments);
        Statistics statistics = new Statistics();
        Statistics stMath = statisticsService.getStatisticByCar(car);
        List<Car> carsCity = carService.getCarsByCity(car.getCity());
        model.addAttribute("stMath", stMath);
        model.addAttribute("carsCity", carsCity);
        model.addAttribute("statistics", statistics);
        if (transactionService.trueUser(carService.getCarById(carId), user) == false) {
            model.addAttribute("message", "Нужно вопсользоваться транспортным средством, чтобы добавить статистику.");
        }
        model.addAttribute("car", car);
        if (user != null)
            return "/carLogIn";
        else
            return "/carLogOut";
    }

}
