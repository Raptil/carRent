package net.carProject.domain;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User commentator;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Column(name = "description")
    private String description;

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public User getCommentator() {
        return commentator;
    }

    public void setCommentator(User commentator) {
        this.commentator = commentator;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id_comment=" + id_comment +
                ", commentator=" + commentator +
                ", car=" + car +
                ", description='" + description + '\'' +
                '}';
    }
}
