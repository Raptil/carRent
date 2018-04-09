package net.carProject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaction;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User renter;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private Car car;

    @Temporal(TemporalType.DATE)
    private Date dayStart;

    @Temporal(TemporalType.DATE)
    private Date dayEnd;

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id_transaction=" + id_transaction +
                ", renter=" + renter +
                ", car=" + car +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd +
                '}';
    }
}
