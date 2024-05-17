import java.time.LocalTime;

public class Shift {
	private LocalTime shiftStart;
    private LocalTime shiftEnd;
	
	public Shift(int number) {
		switch (number) {
			case 1:
				shiftStart = LocalTime.of(8, 0);
				shiftEnd = LocalTime.of(16, 0);
				break;
			case 2:
				shiftStart = LocalTime.of(16, 0);
				shiftEnd = LocalTime.of(23, 59);
				break;
			case 3:
				shiftStart = LocalTime.of(0, 0);
				shiftEnd = LocalTime.of(8, 0);
				break;
		}
	}
	
	public LocalTime getStart() {
		return shiftStart;
	}
	
	public LocalTime getEnd() {
		return shiftEnd;
	}
}
