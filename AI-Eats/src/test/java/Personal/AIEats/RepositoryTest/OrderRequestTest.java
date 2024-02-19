package Personal.AIEats.RepositoryTest;

import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.Entity.order_request;
import Personal.AIEats.Entity.user;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        assertEquals(recent_num, jpaDataOrderRequestRepository.findById(recent_num).get().getRequest_num());
    }

    @Test
    public void findById()
    {
        //given
        user Testuser = new user();
        Testuser.setUser_id("wwwl7749");
        Testuser.setCash(300L);
        Testuser.setPwd("h6644h");
        Testuser.setName("이종원");

        order_request request = new order_request();
        request.setUser_Request_id(Testuser.getUser_id());
        request.setDelivery_location("옐로우피자");
        request.setDelivery_status("배달중");
        request.setMenu_name("콤비네이션");
        request.setMenu_price(3000L);

        user Testuser2 = new user();
        Testuser2.setUser_id("dlwhddnjs951");
        Testuser2.setCash(300L);
        Testuser2.setPwd("h6644h");
        Testuser2.setName("이종원");

        order_request request2 = new order_request();
        request2.setUser_Request_id(Testuser2.getUser_id());
        request2.setDelivery_location("미스터피자");
        request2.setDelivery_status("배달중");
        request2.setMenu_name("콤비네이션");
        request2.setMenu_price(3000L);

        //when
        jpaDataUserRepository.save(Testuser);
        jpaDataOrderRequestRepository.save(request);

        jpaDataUserRepository.save(Testuser2);
        jpaDataOrderRequestRepository.save(request2);

        Long recent_num = jpaDataOrderRequestRepository.save(request).getRequest_num();

        //then
        assertEquals(recent_num, jpaDataOrderRequestRepository.findById(recent_num).get().getRequest_num());
    }

    @Test
    public void findAll()
    {
        //given
        user Testuser = new user();
        Testuser.setUser_id("wwwl7749");
        Testuser.setCash(300L);
        Testuser.setPwd("h6644h");
        Testuser.setName("이종원");

        order_request request = new order_request();
        request.setUser_Request_id(Testuser.getUser_id());
        request.setDelivery_location("옐로우피자");
        request.setDelivery_status("배달중");
        request.setMenu_name("콤비네이션");
        request.setMenu_price(3000L);

        user Testuser2 = new user();
        Testuser2.setUser_id("dlwhddnjs951");
        Testuser2.setCash(300L);
        Testuser2.setPwd("h6644h");
        Testuser2.setName("이종원");

        order_request request2 = new order_request();
        request2.setUser_Request_id(Testuser2.getUser_id());
        request2.setDelivery_location("미스터피자");
        request2.setDelivery_status("배달중");
        request2.setMenu_name("콤비네이션");
        request2.setMenu_price(3000L);

        //when
        jpaDataUserRepository.save(Testuser);
        jpaDataOrderRequestRepository.save(request);

        jpaDataUserRepository.save(Testuser2);
        jpaDataOrderRequestRepository.save(request2);

        List<order_request> result = jpaDataOrderRequestRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
