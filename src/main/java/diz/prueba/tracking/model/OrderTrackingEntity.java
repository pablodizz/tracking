package diz.prueba.tracking.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class OrderTrackingEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private Long trackingStatusId;
	private LocalDateTime changeStatusDate;
	
}
