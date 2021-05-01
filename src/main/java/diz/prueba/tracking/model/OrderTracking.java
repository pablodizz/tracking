package diz.prueba.tracking.model;

import java.time.LocalDateTime;

import com.sun.xml.bind.v2.runtime.unmarshaller.UnmarshallingContext.State;

import diz.prueba.tracking.service.states.EntregadoState;
import diz.prueba.tracking.service.states.IncidenciaState;
import diz.prueba.tracking.service.states.OrderState;
import diz.prueba.tracking.service.states.RecogidaState;
import diz.prueba.tracking.service.states.RepartoState;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class OrderTracking {
	
	private Long orderId;
	private Long trackingStatusId;
	private LocalDateTime changeStatusDate;
	
	private OrderState orderState;

	public OrderTracking(Long orderId, Long trackingStatusId, LocalDateTime changeStatusDate, State state) {
		super();
		this.orderId = orderId;
		this.trackingStatusId = trackingStatusId;
		this.changeStatusDate = changeStatusDate;
		this.orderState = trackingStatusIdtoState(trackingStatusId);
	}
	
	public void updateState(OrderState state) {
		orderState.updateState(this, state);
	}
	
	
	private OrderState trackingStatusIdtoState(Long trackingStatusId) {
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
