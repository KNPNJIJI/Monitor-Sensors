package by.ska.Model.dao;

import by.ska.Model.model.Sensor;

import java.util.List;

public interface SensorDao {

    List<Sensor> findAll();

    //Sensor create(Sensor appUser);

//    void delete(Sensor appUser);

    //Sensor findById(long id);
}
