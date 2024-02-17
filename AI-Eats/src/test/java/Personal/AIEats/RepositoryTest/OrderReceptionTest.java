package Personal.AIEats.RepositoryTest;

import Personal.AIEats.Repository.JpaDataOrderReceptionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class OrderReceptionTest {

    @Autowired
    public JpaDataOrderReceptionRepository orderReceptionRepository;

    @Test
    public void saveTest()
    {

    }
}
