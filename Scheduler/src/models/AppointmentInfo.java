package models;

public class AppointmentInfo {
	Doctors doctorId;
	int personId;
	String appointmentTime;
	boolean isNewPatientAppointment;
	public AppointmentInfo(Doctors doctorId, int personId, String appointmentTime, boolean isNewPatientAppointment) {
		this.doctorId = doctorId;
		this.personId = personId;
		this.appointmentTime = appointmentTime;
		this.isNewPatientAppointment = isNewPatientAppointment;
	}
	public Doctors getDoctorId() {
		return this.doctorId;
	}
	public int getPersonId() {
		return this.personId;
	}
	public String getAppointmentTime() {
		return this.appointmentTime;
	}
	public boolean getIsNewPatientAppointment() {
		return this.isNewPatientAppointment;
	}
	
}
