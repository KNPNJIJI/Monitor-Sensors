package by.ska.Model.model;

//import javax.persistence.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Range")
@Table(name = "range")
@Getter
@Setter
public class Range {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;

    @Column(name = "FROM")
    private int from;

    @Column(name = "TO")
    private int to;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Sensor sensor;

}
