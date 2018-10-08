package net.carProject.controller;


import net.carProject.domain.Car;
import net.carProject.domain.User;
import net.carProject.service.CarService;
import net.carProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "UserService")
    private UserService userService;

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(user);
        return "redirect:/mainLogOut";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password, ModelMap model, HttpSession session) {
        User user = userService.login(email, password);
        model.addAttribute("user", user);
        List<Car> cars = carService.getNewCars();
        List<Car> carsRec = carService.getRecNull();
        model.addAttribute("cars", cars);
        model.addAttribute("carsRec", carsRec);
        session.setAttribute("user", user);
        return "/mainLogIn";
    }

    @RequestMapping(value = "/logout")
    public String logOut(SessionStatus sessionStatus, HttpSession session) {
        sessionStatus.setComplete();
        session.removeAttribute("user");
        session.invalidate();
        return "/mainLogOut";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Car> cars = carService.getCarsByUser(user);
        model.addAttribute("cars", cars);
        model.addAttribute("user", user);
        return "/profile";
    }

    @RequestMapping(value = "/changeProfile", method = RequestMethod.GET)
    public String getOldProfile(ModelMap model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "/changeProfile";
    }

    @RequestMapping(value = "/changeProfile/{userId}", method = RequestMethod.POST)
    public String changeProfile(@PathVariable("userId") int userId,
                                @ModelAttribute("user") User user) {
        user.setId_user(userId);
        userService.changeProfile(user);
        return "/profile";
    }
}
