package Personal.AIEats;

import Personal.AIEats.Repository.JpaDataOrderReceptionRepository;
import Personal.AIEats.Repository.JpaDataOrderRequestRepository;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.Service.CustomerService;
import Personal.AIEats.Service.RiderService;
import Personal.AIEats.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private JpaDataUserRepository UserRepository;
    private JpaDataOrderRequestRepository OrderRequestRespository;
    private JpaDataOrderReceptionRepository OrderReceptionRepository;

    public SpringConfig(JpaDataUserRepository UserRepository, JpaDataOrderRequestRepository jpaDataOrderRequestRepository, JpaDataOrderReceptionRepository jpaDataOrderReceptionRepository)
    {
        this.UserRepository = UserRepository;
        this.OrderReceptionRepository = jpaDataOrderReceptionRepository;
        this.OrderRequestRespository = jpaDataOrderRequestRepository;
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerService(OrderRequestRespository);
    }

    @Bean
    public UserService userService(){
        return new UserService(UserRepository);
    }

    @Bean
    public RiderService riderService() {
        return new RiderService(OrderRequestRespository, OrderReceptionRepository);
    }
}
