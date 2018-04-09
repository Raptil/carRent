package net.carProject.dao;


import net.carProject.domain.Statistics;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsDao extends CRUDImpl<Statistics> {

    public  StatisticsDao(){super(Statistics.class);}
}
