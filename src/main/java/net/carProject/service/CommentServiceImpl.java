package net.carProject.service;


import net.carProject.dao.CommentDao;
import net.carProject.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public List<Comment> getCommentByCarId(int carId) {
        List<Comment> comments = commentDao.readAll();
        List<Comment> query = new ArrayList<Comment>() ;
        for(Comment comment: comments){
            if(comment.getCar().getId_car() == carId)
                query.add(comment);
        }
        return query;
    }
}
