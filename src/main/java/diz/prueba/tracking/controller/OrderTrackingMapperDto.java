package diz.prueba.tracking.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import diz.prueba.tracking.model.OrderTracking;
import diz.prueba.tracking.service.states.EntregadoState;
import diz.prueba.tracking.service.states.IncidenciaState;
import diz.prueba.tracking.service.states.OrderState;
import diz.prueba.tracking.service.states.RecogidaState;
import diz.prueba.tracking.service.states.RepartoState;

@Mapper(componentModel = "spring")
public interface OrderTrackingMapperDto {
	
	@Mapping(source = "changeStatusDate", target = "changeStatusDate", qualifiedByName = "dateToString")
	OrderTrackingDto toDto(OrderTracking source);
	@Mapping(source = "changeStatusDate", target = "changeStatusDate", qualifiedByName = "stringToLocalDateTime")
	@Mapping(source = "trackingStatusId", target = "orderState", qualifiedByName = "trackingStatusIdtoState")
	OrderTracking toPojo(OrderTrackingDto source);
	
	@Named("stringToLocalDateTime")
    public static LocalDateTime stringToLocalDateTime(String changeStatusDate) {
        return LocalDateTime.parse(changeStatusDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
	
	@Named("dateToString")
    public static String stringToLocalDateTime(LocalDateTime changeStatusDate) {
        return DateTimeFormatter.ISO_DATE_TIME.format(changeStatusDate);
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
