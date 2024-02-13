package by.ska.Model.dao;

import by.ska.Model.model.Sensor;
import lombok.SneakyThrows;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@ComponentScan(basePackages = {"by.ska"})
public class SensorDaoImpl implements SensorDao {

    @Autowired
    private SessionFactory sessionFactory;

//    @SneakyThrows
    @Override
    public List<Sensor> findAll() {
        List<Sensor> sensors = sessionFactory.getCurrentSession()
                .createQuery("from Sensor", Sensor.class)
                .list();
        return sensors;
    }
}
