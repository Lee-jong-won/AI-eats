package Personal.AIEats.Entity;

import Personal.AIEats.dto.OrderRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="order_request")
public class order_request {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestnum;
    private String userrequestid;
    private String deliverystatus;
    private String deliverylocation;
    private String menuname;
    private Long menuprice;

    public static order_request toSaveEntity(OrderRequestDTO orderRequestDTO)
    {
        order_request orderRequestEntity = new order_request();
        orderRequestEntity.setUserrequestid(orderRequestDTO.getUserRequestid());
        orderRequestEntity.setMenuname(orderRequestDTO.getMenuname());
        orderRequestEntity.setMenuprice(orderRequestDTO.getMenuprice());
        orderRequestEntity.setDeliverystatus("배차안됨");
        orderRequestEntity.setDeliverylocation(orderRequestDTO.getDeliverylocation());
        return orderRequestEntity;
    }
}

