package diz.prueba.tracking.service.states;


import diz.prueba.tracking.model.OrderTracking;

/**
 * @author Pablo
 *
 */
public class RecogidaState implements OrderState{

	private static Long stateId = 1L;
	
	@Override
	public void updateState(OrderTracking orderTracking, OrderState state) {
		orderTracking.setOrderState(state);
	}
	
	@Override
	public Long getStateId() {
		return RecogidaState.stateId;
	}

}
