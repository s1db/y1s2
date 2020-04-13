package vehicle.types;

public abstract class Aircraft extends Vehicle{
	private double steering;
	
	public Aircraft(String name) {
		setName(name);
		setType(Type.SKIED);
	}

			
	@Override
	public void streer(double degree, double speed) {
		setCurrentSpeed(speed);
		setSteering(degree);
	}
	
	@Override
	public String printSpeed() {
		return getCurrentSpeed()+"km/hr";
	}

	public double getSteering() {
		return steering;
	}


	public void setSteering(double degrees) {
		this.steering = degrees;
	}
}

