package diz.prueba.tracking.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import diz.prueba.tracking.model.OrderTrackingEntity;

@Repository
public interface OrderTrackingRepository extends CrudRepository<OrderTrackingEntity, Long> {

}
