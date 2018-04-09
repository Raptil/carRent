package net.carProject.service;


import net.carProject.domain.Car;
import net.carProject.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface CarService {

    public void save(Car car);

    public List<Car> getCars();

    public List<Car> filterCar(String city, int minCost,int maxCost,
                               String model,String bodyType,int minFuel,
                               int maxFuel);
    public Car getCarById(int id);

    public Car changeCar(Car car);

    public List<Car> getNewCars();

    public  List<Car> getRecNull();

    public List<Car> getCarsByCity(String city);

    public List<Car> getRecommendationCars(String city,String model,String bodyType,String colour);

    public List<Car> getCarsByUser(User user);
}
