package net.carProject.domain;



import javax.persistence.*;

@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_statistics;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Column(name = "distance")
    private int distance;

    @Column(name = "costFuel")
    private int costFuel;

    @Column(name = "comfortable")
    private int comfortable;

    @Column(name = "rating")
    private int rating;

    public int getId_statistics() {
        return id_statistics;
    }

    public void setId_statistics(int id_statistics) {
        this.id_statistics = id_statistics;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCostFuel() {
        return costFuel;
    }

    public void setCostFuel(int costFuel) {
        this.costFuel = costFuel;
    }

    public int getComfortable() {
        return comfortable;
    }

    public void setComfortable(int comfortable) {
        this.comfortable = comfortable;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id_statistics=" + id_statistics +
                ", car=" + car +
                ", distance=" + distance +
                ", costFuel=" + costFuel +
                ", comfortable=" + comfortable +
                ", rating=" + rating +
                '}';
    }
}
