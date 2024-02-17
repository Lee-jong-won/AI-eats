package Personal.AIEats;

import Personal.AIEats.Repository.JpaDataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Autowired
    private JpaDataUserRepository UserRepository;

    public SpringConfig(JpaDataUserRepository UserRepository)
    {
        this.UserRepository = UserRepository;
    }
}
