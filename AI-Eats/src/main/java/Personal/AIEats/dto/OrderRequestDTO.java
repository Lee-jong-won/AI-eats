package Personal.AIEats.dto;

import Personal.AIEats.Entity.order_request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private Long Requestnum;
    private String UserRequestid;
    private String Deliverylocation;
    private String Deliverystatus;
    private String Menuname;
    private Long Menuprice;

    public static OrderRequestDTO toOrderRequestDTO(order_request requestEntity)
    {
        OrderRequestDTO requestDTO = new OrderRequestDTO();
        requestDTO.setRequestnum(requestEntity.getRequestnum());
        requestDTO.setUserRequestid(requestEntity.getUserrequestid());
        requestDTO.setDeliverylocation(requestEntity.getDeliverylocation());
        requestDTO.setMenuname(requestEntity.getMenuname());
        requestDTO.setMenuprice(requestEntity.getMenuprice());
        requestDTO.setDeliverystatus(requestEntity.getDeliverystatus());

        return requestDTO;
    }
}
