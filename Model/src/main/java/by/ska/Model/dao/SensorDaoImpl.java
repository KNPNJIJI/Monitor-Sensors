package by.ska.Model.dao;

import by.ska.Model.model.Sensor;
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

    @Override
    public List<Sensor> findAll() {
        List<Sensor> sensors = sessionFactory.getCurrentSession()
                .createQuery("FROM Sensor", Sensor.class)
                .list();
        return sensors;
    }

    @Override
    public List<Sensor> findOfName(String name){
        String query = "FROM Sensor AS s WHERE s.name LIKE '%" + name + "%'";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<Sensor> findOfModel(String model){
        String query = "FROM Sensor AS s WHERE s.model LIKE '%" + model + "%'";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public void createOrUpdate(Sensor sensor){
        sessionFactory.getCurrentSession().saveOrUpdate(sensor);
    }

    @Override
    public void delete(Sensor sensor){
        Sensor loadedSensor = sessionFactory.getCurrentSession().load(Sensor.class, sensor.getId());
        sessionFactory.getCurrentSession().delete(loadedSensor);
    }
}
