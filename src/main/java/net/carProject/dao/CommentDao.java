package net.carProject.dao;


import net.carProject.domain.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDao extends CRUDImpl<Comment> {

    public CommentDao(){super(Comment.class);}


}
