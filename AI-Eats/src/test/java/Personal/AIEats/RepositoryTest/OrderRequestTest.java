package Personal.AIEats.RepositoryTest;

import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.domain.order_request;
import Personal.AIEats.domain.user;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class OrderRequestTest {

    @Autowired
    private JpaDataOrderRequestRepository jpaDataOrderRequestRepository;

    @Autowired
    private JpaDataUserRepository jpaDataUserRepository;

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

        //when
        jpaDataUserRepository.save(TestUser);
        Long recent_num = jpaDataOrderRequestRepository.save(request).getRequest_num();

        //then
        assertEquals(jpaDataOrderRequestRepository.findById(recent_num).get().getRequest_num(), recent_num);
    }
}
