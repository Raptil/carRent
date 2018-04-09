package net.carProject.service;


import net.carProject.dao.StatisticsDao;
import net.carProject.domain.Car;
import net.carProject.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public void save(Statistics statistics) {
        statisticsDao.save(statistics);
    }

    @Override
    public Statistics getStatisticByCar(Car car) {

        Statistics statistics = new Statistics();
        statistics.setCar(car);
        List<Statistics> stat = statisticsDao.readAll();
        for(Statistics st:stat)
            if(st.getCar().getId_car()==car.getId_car()) {
                statistics.setComfortable(statistics.getComfortable() + st.getComfortable());
                statistics.setCostFuel(statistics.getCostFuel()+st.getCostFuel());
                statistics.setDistance(statistics.getDistance()+st.getDistance());
                statistics.setRating(statistics.getRating()+st.getRating());
            }
        statistics.setComfortable(statistics.getComfortable()/stat.size());
        statistics.setCostFuel(statistics.getCostFuel()/stat.size());
        statistics.setDistance(statistics.getCostFuel()/stat.size());
        statistics.setRating(statistics.getRating()/stat.size());
        return statistics;
    }
}
