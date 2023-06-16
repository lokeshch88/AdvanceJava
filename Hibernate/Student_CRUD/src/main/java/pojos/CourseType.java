package pojos;

public enum CourseType {

	DAC(110000),DBDA(125000),DITISS(100000),DMC(90000);
	private int fee;

	CourseType(int fee) {
		this.fee=fee;
	}
}
