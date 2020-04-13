package vehicle.types;

public class Train extends RailedVehicle {
	
	public Train(String name, int nocarriages) {
		super(name);
		setNocarriages(nocarriages);
	}
	public Train(String name) {
		super(name);
		setNocarriages(4);
	}
}
