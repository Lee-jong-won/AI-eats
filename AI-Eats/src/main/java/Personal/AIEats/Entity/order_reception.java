package Personal.AIEats.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="order_reception")
public class order_reception {

    @Id
    private Long requestnum;
    private String riderid;

}
