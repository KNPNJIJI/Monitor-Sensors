package by.ska.Model.dao;

import by.ska.Model.model.Sensor;

import java.util.List;

public interface SensorDao {

    List<Sensor> findAll();

    List<Sensor> findOfName(String name);

    List<Sensor> findOfModel(String model);

    void createOrUpdate(Sensor sensor);

    void delete(Sensor sensor);
}
