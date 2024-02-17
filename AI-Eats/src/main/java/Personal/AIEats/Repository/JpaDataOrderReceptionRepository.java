package Personal.AIEats.Repository;

import Personal.AIEats.domain.order_reception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDataOrderReceptionRepository extends JpaRepository<order_reception, Long> {

}
