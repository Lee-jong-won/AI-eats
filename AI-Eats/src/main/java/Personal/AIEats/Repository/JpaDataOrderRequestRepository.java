package Personal.AIEats.Repository;

import Personal.AIEats.domain.order_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JpaDataOrderRequestRepository extends JpaRepository<order_request, Long> {

}

