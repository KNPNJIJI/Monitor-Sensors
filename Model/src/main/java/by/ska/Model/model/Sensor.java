package by.ska.Model.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
//import javax.persistence.*;

@Entity(name = "Sensor")
@Table(name = "sensor")
@Getter
@Setter
public class Sensor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @OneToOne(mappedBy = "sensor", cascade = CascadeType.ALL)
    private Range range;

    @Column(name = "TYPE_SENSOR")
    private Type type;

    @Column(name = "UNIT")
    private Unit unit;

    @Column(name = "LOCATION")
    private String location ;

    @Column(name = "DESCRIPTION")
    private String description;

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                ", type=" + type +
                ", unit=" + unit +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

