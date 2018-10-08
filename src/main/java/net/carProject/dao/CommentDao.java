package net.carProject.dao;


import net.carProject.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends CRUDImpl<Comment> {

    public CommentDao() {
        super(Comment.class);
    }


}
