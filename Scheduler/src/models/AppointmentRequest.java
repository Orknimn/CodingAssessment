package models;

public class AppointmentRequest {
	int requestId;
	int personId;
	String[] preferredDays;
	int[] preferredDocs;
	boolean isNew;
	public AppointmentRequest(int requestId, int personId, String[] preferredDays, int[] preferredDocs, boolean isNew) {
		this.requestId = requestId;
		this.personId = personId;
		this.preferredDays = preferredDays;
		this.preferredDocs = preferredDocs;
		this.isNew = isNew;
	}
	public int getRequestId() {
		return this.requestId;
	}
	public int getPersonId() {
		return this.personId;
	}
	public String[] getPreferredDays() {
		return this.preferredDays;
	}
	public int[] getPreferredDocs() {
		return this.preferredDocs;
	}
	public boolean getIsNew() {
		return this.isNew;
	}
	
}
