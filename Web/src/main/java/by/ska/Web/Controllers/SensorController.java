package by.ska.Web.Controllers;

import by.ska.Model.dto.SensorDto;
import by.ska.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@Controller
@ComponentScan(basePackages = {"by.ska.Model.model", "by.ska.Service"})
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("/sensors/")
    @Secured({"ROLE_Administrator", "ROLE_Viewer"})
    @ResponseBody
    public List<SensorDto> findAllSensors() {
        return sensorService.findSensors();
    }

    @GetMapping("/sensors/name={name}")
    @Secured({"ROLE_Administrator", "ROLE_Viewer"})
    @ResponseBody
    public List<SensorDto> findNameOfSensors(@PathVariable("name") String name) {
        return sensorService.findNameOfSensors(name);
    }

    @GetMapping("/sensors/model={model}")
    @Secured({"ROLE_Administrator", "ROLE_Viewer"})
    @ResponseBody
    public List<SensorDto> findModelOfSensors(@PathVariable("model") String model) {
        return sensorService.findModelOfSensors(model);
    }

    @PostMapping("/add-sensor")
    @Secured({"ROLE_Administrator"})
    public ResponseEntity<?> createOrUpdate(@RequestBody SensorDto sensorDto) {
        try {
            sensorService.createOrUpdate(sensorDto);
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete-sensor")

    @Secured({"ROLE_Administrator"})
    @ResponseBody
    public ResponseEntity<?> deleteSensor(@RequestBody SensorDto sensorDto) {

        sensorService.delete(sensorDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
