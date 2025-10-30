package models;
public class AppointmentInfoRequest {
	Doctors doctorId;
	int personId;
	String appointmentTime;
	boolean isNewPatientAppointment;
	int requestId;
	public AppointmentInfoRequest(Doctors doctorId, int personId, String appointmentTime, boolean isNewPatientAppointment, int requestId) {
		this.doctorId = doctorId;
		this.personId = personId;
		this.appointmentTime = appointmentTime;
		this.isNewPatientAppointment = isNewPatientAppointment;
		this.requestId = requestId;
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
	public int getRequestId() {
		return this.requestId;
	}
}
