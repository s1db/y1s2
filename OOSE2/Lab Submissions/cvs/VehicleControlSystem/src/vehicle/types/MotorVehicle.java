package vehicle.types;

public abstract class MotorVehicle extends Vehicle{
	
	private int nowheels;
	
	public MotorVehicle(String name) {
		setName(name);
		setType(Type.WHEELED);
	}

	public int getNowheels() {
		return nowheels;
	}

	public void setNowheels(int nowheels) {
		this.nowheels = nowheels;
	}
			
	@Override
	public void drive(Direction direction, double speed) {
		setStopped(false);
		setDirection(direction);
		setCurrentSpeed(speed);
		
	}
	
	@Override
	public String printSpeed() {
		return getCurrentSpeed()+"miles/hr";
	}

}
