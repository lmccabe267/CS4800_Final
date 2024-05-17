import java.time.LocalTime;

public class Driver extends Person {
    private Shift shift;

    public Driver(String name, String address, String county, int shiftNumber) {
        super(name, address, county);
        this.shift = new Shift(shiftNumber);
    }

    public boolean isAvailable() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(shift.getStart()) && !now.isAfter(shift.getEnd());
    }

	public LocalTime getShiftStart() {
		return shift.getStart();
	}

	public LocalTime getShiftEnd() {
		return shift.getEnd();
	}
    
    
}
