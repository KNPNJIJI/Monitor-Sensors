package by.ska.Model.model;

import by.ska.Model.util.UnitConverter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Sensor")
@Table(name = "sensor")
@Getter
@Setter
public class Sensor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "t_employee_seq")
    private long id;

    @NotNull
    @Column(name = "NAME")
    @Length(min = 3, max = 30)
    private String name;

    @NotNull
    @Column(name = "MODEL")
    @Length(max = 15)
    private String model;

    @OneToOne(mappedBy = "sensor", cascade = CascadeType.ALL)
    private Range range;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_SENSOR")
    private Type type;

    @Convert(converter = UnitConverter.class)
    @Column(name = "UNIT")
    private Unit unit;

    @Column(name = "LOCATION")
    @Length(max = 40)
    private String location ;

    @Column(name = "DESCRIPTION")
    @Length(max = 200)
    private String description;
}

