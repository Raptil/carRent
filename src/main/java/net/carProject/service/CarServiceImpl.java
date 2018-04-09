package net.carProject.service;

import net.carProject.dao.CarDao;
import net.carProject.dao.TransactionDao;
import net.carProject.domain.Car;
import net.carProject.domain.Transaction;
import net.carProject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CarService")
public class CarServiceImpl implements CarService{

    @Autowired
    @Qualifier(value = "CarDao")
    private CarDao carDao;

    @Autowired
    private TransactionDao transactionDao;
    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public List<Car> filterCar(String city, int minCost, int maxCost, String model, String bodyType, int minFuel, int maxFuel) {
        return carDao.filterCar(city,minCost,maxCost,model,bodyType,minFuel,maxFuel);
    }

    @Override
    public List<Car> getCars() {
        Date today = new Date();
        List<Transaction> transactions = transactionDao.readAll();
        List<Car> cars = carDao.readAll();
        for( Transaction transaction:transactions)
            if (today.after(transaction.getDayEnd()))
                cars.remove(transaction.getCar());
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        return carDao.read(id);
    }

    @Override
    public Car changeCar(Car car) {
        return carDao.update(car);
    }

    @Override
    public List<Car> getNewCars() {
        return carDao.getNewCars();
    }

    @Override
    public List<Car> getRecommendationCars(String city, String model, String bodyType, String colour) {
        return carDao.getRecommendationCars(city,model,bodyType,colour);
    }

    @Override
    public List<Car> getRecNull() {
        return carDao.getRecNull();
    }

    @Override
    public List<Car> getCarsByCity(String city) {
        return carDao.getCarByCity(city);
    }

    @Override
    public List<Car> getCarsByUser(User user){
        List<Car> cars=carDao.readAll();
        List<Car> require = new ArrayList<>();
        for(Car car:cars)
            if(car.getOwner().getId_user()==user.getId_user())
                require.add(car);
        return require;
    }
}
