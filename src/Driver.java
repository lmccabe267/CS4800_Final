import java.time.LocalTime;

public class Driver extends Person {
    private LocalTime shiftStart;
    private LocalTime shiftEnd;

    public Driver(String name, String address, String county, LocalTime shiftStart, LocalTime shiftEnd) {
        super(name, address, county);
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
    }

    public boolean isAvailable() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(shiftStart) && !now.isAfter(shiftEnd);
    }

	public LocalTime getShiftStart() {
		return shiftStart;
	}

	public LocalTime getShiftEnd() {
		return shiftEnd;
	}
    
    
}
