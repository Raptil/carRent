package net.carProject.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import net.carProject.domain.Comment;
import net.carProject.domain.User;
import net.carProject.service.CarService;
import net.carProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CarService carService;

    @RequestMapping(value="/addComment/{carId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("carId")int carId,
                             @RequestParam("comment") String comment, HttpSession session){
        User user= (User) session.getAttribute("user");
        Comment cmt = new Comment();
        cmt.setDescription(comment);
        cmt.setCar(carService.getCarById(carId));
        cmt.setCommentator(user);
        commentService.save(cmt);
        return "redirect:/car/{carId}";
    }

    @RequestMapping(value = "/comments/{carId}",method = RequestMethod.GET)
    public String getComments(@PathVariable("carId") int carId, Model model){
        List<Comment> comments=commentService.getCommentByCarId(carId);
        model.addAttribute("comments",comments);
        return"/car";
    }
}
