package Personal.AIEats.Repository;

import Personal.AIEats.Entity.order_request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JpaDataOrderRequestRepository extends JpaRepository<order_request, Long> {

    public List<order_request> findAllByuserrequestid(String userrequestid);
}

