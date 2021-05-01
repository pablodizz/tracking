package diz.prueba.tracking.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import diz.prueba.tracking.model.OrderTracking;
import diz.prueba.tracking.model.OrderTrackingEntity;
import diz.prueba.tracking.service.states.EntregadoState;
import diz.prueba.tracking.service.states.IncidenciaState;
import diz.prueba.tracking.service.states.OrderState;
import diz.prueba.tracking.service.states.RecogidaState;
import diz.prueba.tracking.service.states.RepartoState;

@Mapper(componentModel = "spring")
public interface OrderTrackingMapper {
	
	OrderTrackingMapper INSTANCE = Mappers.getMapper( OrderTrackingMapper.class );
	
	@Mapping(source = "orderState", target = "trackingStatusId", qualifiedByName = "trackingStatusId")
	OrderTrackingEntity toEntity(OrderTracking source);
	@Mapping(source = "trackingStatusId", target = "orderState", qualifiedByName = "trackingStatusIdtoState")
	OrderTracking toPojo(OrderTrackingEntity source);
	
	@Named("trackingStatusId")
    public static Long stateToTrackingStatusId(OrderState orderState) {
       return orderState.getStateId();
    }
	
	@Named("trackingStatusIdtoState")
	public static OrderState trackingStatusIdtoState(Long trackingStatusId) {
		switch (trackingStatusId.intValue()) {
		case 1:
			return new RecogidaState();
		case 2:
			return new RepartoState();
		case 3:
			return new IncidenciaState();
		case 4:
			return new EntregadoState();
		default:
			return new RecogidaState();
		}
	}
	
}
