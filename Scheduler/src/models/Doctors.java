package models;

public enum Doctors {
	DOCTOR_ONE(1), DOCTOR_TWO(2), DOCTOR_THREE(3);
	private final int id;
	Doctors(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}
