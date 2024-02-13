package by.ska.Web.Controllers;

import by.ska.Model.model.Sensor;
import by.ska.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@ComponentScan(basePackages = {"by.ska.Model.model", "by.ska.Service"})
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/sensors")
    @ResponseBody
    public List<Sensor> findAllSensors() {
        List<Sensor> sensors = sensorService.findSensors();

        return sensors;
    }
}
