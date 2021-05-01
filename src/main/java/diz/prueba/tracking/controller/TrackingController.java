package diz.prueba.tracking.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diz.prueba.tracking.model.OrderTracking;
import diz.prueba.tracking.service.OrderTrackingService;

@RestController
@RequestMapping(value = "/order/tracking")
public class TrackingController {
	

	@Autowired
	OrderTrackingService orderTrackingService;
	
	@Autowired
	OrderTrackingMapperDto mapper;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public OrderTrackingWrapper saveOrderTrakings (@RequestBody OrderTrackingWrapper orderTrackings) {
		List <OrderTracking> orders = orderTrackings.getOrderTrackings().stream().map(order -> mapper.toPojo(order)).collect(Collectors.toList());
		List<OrderTracking> ordersFromDB = orderTrackingService.saveAll(orders);
		return orderTrackingService.wrap(ordersFromDB);
	}
	
}
