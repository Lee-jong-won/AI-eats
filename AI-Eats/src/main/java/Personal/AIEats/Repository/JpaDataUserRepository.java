package Personal.AIEats.Repository;

import Personal.AIEats.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDataUserRepository extends JpaRepository<user, String> {
}
