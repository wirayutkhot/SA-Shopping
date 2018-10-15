package cpe.repository;

import cpe.entity.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderID(Long orderID);
}
