package net.carProject.service;

import net.carProject.domain.Car;
import net.carProject.domain.Statistics;

/**
 * Created by Алексей on 30.05.2017.
 */
public interface StatisticsService {

    public void save(Statistics statistics);

    public Statistics getStatisticByCar(Car car);
}
