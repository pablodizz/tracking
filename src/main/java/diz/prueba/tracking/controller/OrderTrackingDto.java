package diz.prueba.tracking.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderTrackingDto {
	
	private Long orderId;
	private Long trackingStatusId;
	private String changeStatusDate;
}
