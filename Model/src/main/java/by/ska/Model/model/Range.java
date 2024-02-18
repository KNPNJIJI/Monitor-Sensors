package by.ska.Model.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Range")
@Table(name = "t_range")
@Getter
@Setter
@JsonIgnoreProperties({ "sensor" })
public class Range {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "sensor")
    )
    private long id;

    @Column(name = "F_FROM")
    private int from;

    @Column(name = "F_TO")
    private int to;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Sensor sensor;

}
