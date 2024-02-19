package Personal.AIEats.Repository;

import Personal.AIEats.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDataUserRepository extends JpaRepository<user, String> {
}
