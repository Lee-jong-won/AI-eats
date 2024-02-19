package Personal.AIEats.Service;

import Personal.AIEats.Repository.JpaDataOrderReceptionRepository;
import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.Entity.order_request;
import Personal.AIEats.dto.OrderRequestDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {

    private JpaDataOrderRequestRepository OrderRequestRespository;

    public CustomerService(JpaDataOrderRequestRepository jpaDataOrderRequestRepository)
    {
        this.OrderRequestRespository = jpaDataOrderRequestRepository;
    }

    public void RequestRegister(OrderRequestDTO orderRequestDTO)
    {
        order_request requestEntity = order_request.toSaveEntity(orderRequestDTO);
        OrderRequestRespository.save(requestEntity);
    }

    public void CancelRequest(Long request_Num)
    {
        OrderRequestRespository.delete(OrderRequestRespository.findById(request_Num).get());
    }

    public List<OrderRequestDTO> findAllRequest(String memberID)
    {
        List<order_request> orderRequests = OrderRequestRespository.findAllByuserrequestid(memberID);
        List<OrderRequestDTO> orderRequestDTOS = new ArrayList<>();
        for(order_request requestEntity: orderRequests)
        {
            orderRequestDTOS.add(OrderRequestDTO.toOrderRequestDTO(requestEntity));
        }

        return orderRequestDTOS;
    }

    public OrderRequestDTO findByID(Long id)
    {
        Optional<order_request> optionalOrderRequest = OrderRequestRespository.findById(id);
        if(optionalOrderRequest.isPresent())
        {
            order_request orderRequestEntity = optionalOrderRequest.get();
            OrderRequestDTO orderRequestDTO = OrderRequestDTO.toOrderRequestDTO(orderRequestEntity);
            return orderRequestDTO;
        }
        else {
            return null;
        }
    }


    public void delete(Long ID)
    {
        OrderRequestRespository.deleteById(ID);
    }
}
