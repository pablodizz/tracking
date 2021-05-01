package diz.prueba.tracking.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diz.prueba.tracking.controller.OrderTrackingDto;
import diz.prueba.tracking.controller.OrderTrackingMapperDto;
import diz.prueba.tracking.controller.OrderTrackingWrapper;
import diz.prueba.tracking.data.OrderTrackingRepository;
import diz.prueba.tracking.model.OrderTracking;
import diz.prueba.tracking.model.OrderTrackingEntity;
import diz.prueba.tracking.service.states.OrderState;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService{

	@Autowired
	public OrderTrackingRepository repository;
	
	@Autowired
	public OrderTrackingMapper mapper;
	
	@Autowired
	public OrderTrackingMapperDto mapperDto;

	@Override
	public OrderTracking save(OrderTracking orderTracking) {
		OrderTrackingEntity result = repository.save(mapper.toEntity(orderTracking));
		
		return mapper.toPojo(result);
	}

	@Override
	public List<OrderTracking> saveAll(List<OrderTracking> orders) {
		return 	orders.stream().map(order -> {
				Optional<OrderTrackingEntity> orderdb = repository.findById(order.getOrderId());
				if(orderdb.isPresent()) {
					OrderTracking orderPojo = mapper.toPojo(orderdb.get());
					OrderState futureState = order.getOrderState();
					orderPojo.updateState(futureState);
					return this.save(orderPojo);
				}
				return null;
			})
			.filter(order -> order!=null)
			.collect(Collectors.toList());
	}

	@Override
	public OrderTrackingWrapper wrap(List<OrderTracking> orders) {
		List<OrderTrackingDto> ordersDto = orders.stream().map(order -> mapperDto.toDto(order)).collect(Collectors.toList());
		return new OrderTrackingWrapper(ordersDto);
		
	}
	
	
}
