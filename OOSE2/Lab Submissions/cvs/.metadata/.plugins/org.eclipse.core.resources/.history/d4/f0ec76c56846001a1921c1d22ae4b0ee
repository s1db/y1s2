package vehicle.types;

public abstract class RailedVehicle extends Vehicle{
	int nocarriages;
	
	public RailedVehicle(String name) {
		setName(name);
		setType(Type.RAILED);
	}


	public int getNocarriages() {
		return nocarriages;
	}

	public void setNocarriages(int nocarriages) {
		this.nocarriages = nocarriages;
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
