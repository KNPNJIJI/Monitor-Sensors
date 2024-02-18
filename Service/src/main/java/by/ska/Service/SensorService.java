package by.ska.Service;

import by.ska.Model.dao.SensorDao;
import by.ska.Model.dto.RangeDto;
import by.ska.Model.dto.SensorDto;
import by.ska.Model.model.Range;
import by.ska.Model.model.Sensor;
import by.ska.Model.model.Unit;
import by.ska.Service.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@ComponentScan(basePackages = {"by.ska.Model.dao"})
public class SensorService {

    @Autowired
    SensorDao sensorDao;

    @Autowired
    private ModelMapper modelMapper;

    public List<SensorDto> findSensors() {
        List<Sensor> sensors = sensorDao.findAll();

        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }

    public List<SensorDto> findNameOfSensors(String name) {
        List<Sensor> sensors = sensorDao.findOfName(name);

        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }

    public List<SensorDto> findModelOfSensors(String model) {
        List<Sensor> sensors = sensorDao.findOfModel(model);

        return MapperUtil.convertList(sensors, this::convertToSensorDto);
    }

    public void createOrUpdate(SensorDto sensorDto){
        Sensor sensor = modelMapper.map(sensorDto, Sensor.class);
        sensor.getRange().setSensor(sensor);
        sensor.setUnit(Stream.of(Unit.values())
                .filter(c -> c.getTitle().equals(sensorDto.getUnit()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new));

        sensorDao.createOrUpdate(sensor);
    }

    public void delete(SensorDto sensorDto) {
        Sensor sensor = modelMapper.map(sensorDto, Sensor.class);
        sensorDao.delete(sensor);
    }

        private SensorDto convertToSensorDto(Sensor sensor) {
        SensorDto sensorDto = modelMapper.map(sensor, SensorDto.class);
        sensorDto.setRangeDto(modelMapper.map(sensor.getRange(), RangeDto.class));
        sensorDto.setUnit(sensor.getUnit().getTitle());
        return sensorDto;
    }

    private RangeDto convertToRangeDto(Range range) {
        return modelMapper.map(range, RangeDto.class);
    }
}
