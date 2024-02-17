package Personal.AIEats.RepositoryTest;

import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.domain.user;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class UserTest {

    @Autowired
    private JpaDataUserRepository userRepository;

    @Test
    public void saveTest()
    {
        //given
        user TestUser = new user();
        TestUser.setUser_id("wwwl7749");
        TestUser.setCash(300L);
        TestUser.setPwd("h6644h");
        TestUser.setName("이종원");

        //when
        user TestUser2 = userRepository.save(TestUser);

        //then
        assertEquals(TestUser2.getUser_id(), TestUser.getUser_id());
    }


    @Test
    public void findByIdTest()
    {
        //given
        user Testuser = new user();
        Testuser.setUser_id("wwwl7749");
        Testuser.setCash(300L);
        Testuser.setPwd("h6644h");
        Testuser.setName("이종원");

        user Testuser2 = new user();
        Testuser2.setUser_id("dlwhddnjs951");
        Testuser2.setCash(300L);
        Testuser2.setPwd("h6644h");
        Testuser2.setName("이종원");

        //when
        userRepository.save(Testuser);
        userRepository.save(Testuser2);
        user result = userRepository.findById("dlwhddnjs951").get();

        //then
        assertEquals(Testuser2.getUser_id(), result.getUser_id());
    }

    @Test
    public void findAllTest()
    {
        //given
        user Testuser = new user();
        Testuser.setUser_id("wwwl7749");
        Testuser.setCash(300L);
        Testuser.setPwd("h6644h");
        Testuser.setName("이종원");

        user Testuser2 = new user();
        Testuser2.setUser_id("dlwhddnjs951");
        Testuser2.setCash(300L);
        Testuser2.setPwd("h6644h");
        Testuser2.setName("이종원");

        //when
        userRepository.save(Testuser);
        userRepository.save(Testuser2);
        List<user> result = userRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }



}
