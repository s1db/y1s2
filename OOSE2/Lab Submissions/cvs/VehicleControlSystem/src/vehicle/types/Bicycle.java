package vehicle.types;

public class Bicycle extends Vehicle{
private double steering;
	
	public Bicycle(String name) {
		setName(name);
		setType(Type.WHEELED);
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
