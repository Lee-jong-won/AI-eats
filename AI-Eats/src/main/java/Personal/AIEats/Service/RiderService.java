package Personal.AIEats.Service;

import Personal.AIEats.Entity.order_request;
import Personal.AIEats.Repository.JpaDataOrderReceptionRepository;
import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.dto.OrderRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class RiderService {
    private JpaDataOrderRequestRepository OrderRequestRespository;
    private JpaDataOrderReceptionRepository OrderReceptionRepository;

    public RiderService(JpaDataOrderRequestRepository jpaDataOrderRequestRepository, JpaDataOrderReceptionRepository jpaDataOrderReceptionRepository)
    {
        this.OrderReceptionRepository = jpaDataOrderReceptionRepository;
        this.OrderRequestRespository = jpaDataOrderRequestRepository;
    }

    public List<OrderRequestDTO> findAllRequest()
    {
        List<order_request> orderRequests = OrderRequestRespository.findAll();
        List<OrderRequestDTO> orderRequestDTOS = new ArrayList<>();
        for(order_request requestEntity: orderRequests)
        {
            orderRequestDTOS.add(OrderRequestDTO.toOrderRequestDTO(requestEntity));
        }
        return orderRequestDTOS;
    }




}
