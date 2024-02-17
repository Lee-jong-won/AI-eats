package Personal.AIEats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_reception")
public class order_reception {

    @Id
    private Long Order_Request_Request_num;
    private String User_Rider_id;

    public Long getOrder_Request_Request_num() {
        return Order_Request_Request_num;
    }

    public void setOrder_Request_Request_num(Long order_Request_Request_num) {
        Order_Request_Request_num = order_Request_Request_num;
    }

    public String getUser_Rider_id() {
        return User_Rider_id;
    }

    public void setUser_Rider_id(String user_Rider_id) {
        User_Rider_id = user_Rider_id;
    }
}
