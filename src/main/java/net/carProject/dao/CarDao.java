package net.carProject.dao;


import net.carProject.domain.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository("CarDao")
public class CarDao extends CRUDImpl<Car> {

    public CarDao(){super(Car.class);}

    public List<Car> filterCar(String city,int minCost, int maxCost,String model,
                               String bodyType,int minFuel, int maxFuel){
        String filterBD;

        if((city!="")||(maxCost!=0)||(model!="")||(bodyType!="")||(maxFuel!=0)) {
            filterBD="SELECT c " +
                    "FROM Car c "+
                     "WHERE";
            if (city != "")
                filterBD = filterBD + " (c.city=:city) ";
            if (maxCost != 0)
                filterBD = filterBD + " AND (c.priceDay BETWEEN :minCost AND :maxCost) ";
            else if (minCost != 0)
                filterBD = filterBD + " AND (c.priceDay > minCost) ";
            if (model != "")
                filterBD = filterBD + " AND (c.model=:model) ";
            if (bodyType != "")
                filterBD = filterBD + " AND (c.bodyType=:bodyType) ";
            if (maxFuel != 0)
                filterBD = filterBD + " AND (c.fuel100 BETWEEN :minFuel AND :maxFuel) ";
            else if (minFuel != 0)
                filterBD = filterBD + " AND (c.fuel100 > minFuel) ";
        }
        else { filterBD="FROM Car";}
        TypedQuery<Car> query = entityManager.createQuery(filterBD,Car.class);

        if (city != "")
        query.setParameter("city",city);
        if (maxCost != 0){
        query.setParameter("minCost",minCost);
        query.setParameter("maxCost",maxCost);}
        if (bodyType != "")
        query.setParameter("bodyType",bodyType);
        if (model != "")
        query.setParameter("model",model);
        if (maxFuel != 0){
        query.setParameter("minFuel",minFuel);
        query.setParameter("maxFuel",maxFuel);}

        List<Car> cars=query.getResultList();

        return cars;
    }

    public  List<Car> getNewCars(){
        TypedQuery<Car> query = entityManager.createQuery("select c " +
                "FROM Car c " +
                "ORDER BY c.id_car DESC ",Car.class);
        query.setMaxResults(4);
        List<Car> cars = query.getResultList();

        return cars;
    }
    public List<Car> getRecNull(){
        TypedQuery<Car> query = entityManager.createQuery("SELECT  c " +
                "FROM  Car c " +
                "ORDER BY c.pointsCar DESC ",Car.class);
        query.setMaxResults(4);
        List<Car> cars= query.getResultList();
        return cars;
    }

    public List<Car> getCarByCity(String city){
        TypedQuery<Car>query = entityManager.createQuery("SELECT c " +
                "FROM  Car c " +
                "WHERE c.city=:city " +
                "ORDER BY c.pointsCar DESC ",Car.class);
        query.setMaxResults(3);
        query.setParameter("city",city);
        List<Car> cars = query.getResultList();

        return cars;
    }

    public List<Car> getRecommendationCars(String city, String model, String bodyType,String colour){
        List<Car> cars = new ArrayList();
        TypedQuery<Car> query = entityManager.createQuery("SELECT c " +
                "FROM Car c " +
                "WHERE c.city=:city " +
                "order by pointsCar desc ",Car.class);
        query.setParameter("city",city);
        cars.add(query.getSingleResult());
        query = entityManager.createQuery("SELECT c " +
                "FROM Car c " +
                "WHERE c.model=:model " +
                "order by pointsCar desc ",Car.class);
        query.setParameter("model",model);
        cars.add(query.getSingleResult());
        query = entityManager.createQuery("SELECT c " +
                "FROM Car c " +
                "WHERE c.bodyType=:bodyType " +
                "order by pointsCar desc ",Car.class);
        query.setParameter("bodyType",bodyType);
        cars.add(query.getSingleResult());
      query = entityManager.createQuery("SELECT c " +
                "FROM Car c " +
                "WHERE c.colour=:colour " +
                "order by pointsCar desc ",Car.class);
      query.setParameter("colour",colour);
      cars.add(query.getSingleResult());
        return cars;
    }

}
