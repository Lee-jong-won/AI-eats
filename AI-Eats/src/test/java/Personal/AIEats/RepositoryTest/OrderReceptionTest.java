package Personal.AIEats.RepositoryTest;

import Personal.AIEats.Repository.JpaDataOrderReceptionRepository;
import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.Entity.order_reception;
import Personal.AIEats.Entity.order_request;
import Personal.AIEats.Entity.user;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderReceptionTest {

    @Autowired
    public JpaDataOrderReceptionRepository orderReceptionRepository;

    @Autowired
    public JpaDataUserRepository jpaDataUserRepository;

    @Autowired
    public JpaDataOrderRequestRepository jpaDataOrderRequestRepository;

    @Test
    public void save()
    {
        //given
        user TestUser = new user();
        TestUser.setUser_id("wwwl7749");
        TestUser.setCash(300L);
        TestUser.setPwd("h6644h");
        TestUser.setName("이종원");

        order_request request = new order_request();
        request.setUser_Request_id(TestUser.getUser_id());
        request.setDelivery_location("옐로우피자");
        request.setDelivery_status("배달중");
        request.setMenu_name("콤비네이션");
        request.setMenu_price(3000L);

        user TestUser2 = new user();
        TestUser2.setUser_id("withshim");
        TestUser2.setCash(300L);
        TestUser2.setPwd("h6644h");
        TestUser2.setName("심찬우");

        order_reception reception = new order_reception();
        jpaDataUserRepository.save(TestUser);
        Long recent_num = jpaDataOrderRequestRepository.save(request).getRequest_num();
        jpaDataUserRepository.save(TestUser2);
        reception.setOrder_Request_Request_num(recent_num);
        reception.setUser_Rider_id("withshim");

        //when
        Long result = orderReceptionRepository.save(reception).getOrder_Request_Request_num();

        //that
        assertEquals(recent_num, result);
    }

    @Test
    public void delete()
    {
        //given
        user TestUser = new user();
        TestUser.setUser_id("wwwl7749");
        TestUser.setCash(300L);
        TestUser.setPwd("h6644h");
        TestUser.setName("이종원");

        order_request request = new order_request();
        request.setUser_Request_id(TestUser.getUser_id());
        request.setDelivery_location("옐로우피자");
        request.setDelivery_status("배달중");
        request.setMenu_name("콤비네이션");
        request.setMenu_price(3000L);

        user TestUser2 = new user();
        TestUser2.setUser_id("withshim");
        TestUser2.setCash(300L);
        TestUser2.setPwd("h6644h");
        TestUser2.setName("심찬우");

        order_reception reception = new order_reception();
        jpaDataUserRepository.save(TestUser);
        Long recent_num = jpaDataOrderRequestRepository.save(request).getRequest_num();
        jpaDataUserRepository.save(TestUser2);
        reception.setOrder_Request_Request_num(recent_num);
        reception.setUser_Rider_id("withshim");

        //when
        Long recent_ID = orderReceptionRepository.save(reception).getOrder_Request_Request_num();
        orderReceptionRepository.delete(orderReceptionRepository.findById(recent_ID).get());

        //that
        assertEquals(1, jpaDataOrderRequestRepository.count());
    }
}
