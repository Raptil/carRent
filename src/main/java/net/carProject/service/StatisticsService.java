package net.carProject.service;

import net.carProject.domain.Car;
import net.carProject.domain.Statistics;


public interface StatisticsService {

    public void save(Statistics statistics);

    public Statistics getStatisticByCar(Car car);
}
