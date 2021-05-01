package diz.prueba.tracking.service.states;

import diz.prueba.tracking.model.OrderTracking;

public class RepartoState implements OrderState {
	
	private static Long stateId = 2L;

	@Override
	public void updateState(OrderTracking orderTracking, OrderState state) {
		if(!(state instanceof RecogidaState)) {
			orderTracking.setOrderState(state);
		}
	}
	
	@Override
	public Long getStateId() {
		return RepartoState.stateId;
	}

}
