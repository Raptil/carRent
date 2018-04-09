package net.carProject.service;


import net.carProject.domain.Comment;

import java.util.List;

public interface CommentService {

    public void save(Comment comment);

    public List<Comment> getCommentByCarId(int carId);
}
