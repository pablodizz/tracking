package diz.prueba.tracking.controller;

import java.util.List;

import lombok.Data;

@Data
public class OrderTrackingWrapper {

	private List<OrderTrackingDto> orderTrackings;

	public OrderTrackingWrapper(List<OrderTrackingDto> orders) {
		super();
		this.orderTrackings = orders;
	}

	public OrderTrackingWrapper() {
		super();
	}
	
	
}
