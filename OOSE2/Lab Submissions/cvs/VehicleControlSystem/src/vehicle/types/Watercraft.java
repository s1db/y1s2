package vehicle.types;

public abstract class Watercraft extends Vehicle{
	private double steering;
	
	public Watercraft(String name) {
		setName(name);
		setType(Type.FLOATED);
	}

			
	@Override
	public void streer(double degree, double speed) {
		setCurrentSpeed(speed);
		setSteering(degree);
	}

	@Override
	public String printSpeed() {
		return getCurrentSpeed()+"knots";
	}

	public double getSteering() {
		return steering;
	}


	public void setSteering(double degrees) {
		this.steering = degrees;
	}
}

