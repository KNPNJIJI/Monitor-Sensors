package by.ska.Model.dto;

import by.ska.Model.model.Type;
import by.ska.Model.model.Unit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDto {

    @JsonProperty("range")
    private RangeDto rangeDto;
    private String name;
    private String model;
    private Type type;
    private String unit;
    private String location ;
    private String description;
}
