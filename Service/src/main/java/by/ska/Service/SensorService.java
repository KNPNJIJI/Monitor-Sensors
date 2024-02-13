package by.ska.Service;

import by.ska.Model.dao.SensorDao;
import by.ska.Model.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"by.ska.Model.dao"})
public class SensorService {

    @Autowired
    SensorDao sensorDao;

    public List<Sensor> findSensors() {
        List<Sensor> appUsers = sensorDao.findAll();

        return appUsers;
    }
}
