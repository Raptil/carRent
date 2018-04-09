package net.carProject.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // объявляет, что это клас - сущность
@Table(name = "car") // явно задаем название таблицы
public class Car {

    @Id // аннотация, указывающая, что данное поле является id при маппинге
    @GeneratedValue(strategy = GenerationType.IDENTITY) // стратегия генерации id
    private int id_car;

    @ManyToOne // указывает отношение с таблицей User
    @JoinColumn(name = "id_user") // по какому полю таблицы соединяются
    private  User owner;

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY) // маппится на car, также загрузка идет при обращении
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY)
    private List<Transaction> transactions=new ArrayList<Transaction>();

    public List<Statistics> getStatistics() {
        return statistics;
    } // для всех полей устанавливаются get методы

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }// для всех полей устанавливаются set методы

    public int getPointsCar() {
        return pointsCar;
    }

    public void setPointsCar(int pointsCar) {
        this.pointsCar = pointsCar;
    }

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY)
    private List<Statistics> statistics = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Column(name="model")// явно задается название колонки, которое есть в таблице
    @NotNull// поле не должно быть null
    private String model;

    @Column(name = "bodyType")
    @NotNull
    private String bodyType;

    @Column(name="stateNumber")
    @NotNull
    private String stateNumber;

    @Column(name="numberOfDoc")
    @NotNull
    private String numberOfDoc;

    @Column(name="priceDay")
    @NotNull
    private int priceDay;

    @Column(name = "fuel100")
    @NotNull
    private int fuel100;

    @Column(name = "yearsOld")
    @NotNull
    private int yearsOld;

    @Column(name = "colour")
    private String colour;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "otherDescription")
    private String otherDescription;

    @Column(name = "pointsCar")
    private int pointsCar;

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getNumberOfDoc() {
        return numberOfDoc;
    }

    public void setNumberOfDoc(String numberOfDoc) {
        this.numberOfDoc = numberOfDoc;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public int getFuel100() {
        return fuel100;
    }

    public void setFuel100(int fuel100) {
        this.fuel100 = fuel100;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    @Override // переопределение методы
    public String toString() {
        return "Car{" +
                "id_car=" + id_car +
                ", owner=" + owner +
                ", comments=" + comments +
                ", transactions=" + transactions +
                ", statistics=" + statistics +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", stateNumber='" + stateNumber + '\'' +
                ", numberOfDoc='" + numberOfDoc + '\'' +
                ", priceDay=" + priceDay +
                ", fuel100=" + fuel100 +
                ", yearsOld=" + yearsOld +
                ", colour='" + colour + '\'' +
                ", city='" + city + '\'' +
                ", otherDescription='" + otherDescription + '\'' +
                ", pointsCar=" + pointsCar +
                '}';
    }
}
