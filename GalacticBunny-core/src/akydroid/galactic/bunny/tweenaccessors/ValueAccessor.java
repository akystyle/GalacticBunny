package akydroid.galactic.bunny.tweenaccessors;

import aurelienribon.tweenengine.TweenAccessor;

public class ValueAccessor implements TweenAccessor<Value>{

	@Override
	public int getValues(Value target, int type, float[] returnValues) {
		returnValues[0] = target.getValue();
		return 1;
	}

	@Override
	public void setValues(Value target, int type, float[] newValues) {
		target.setValue(newValues[0]);
	}
}