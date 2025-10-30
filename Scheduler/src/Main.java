
import service.SchedulingService;

import java.util.LinkedList;
import java.util.Queue;

import models.AppointmentInfo;
import models.AppointmentRequest;

public class Main {

	public static void main(String[] args) {
		

		
		SchedulingService service = new SchedulingService();
		Queue<AppointmentRequest> apptReqs = new LinkedList<>();
		int requestBuffer = 10;
		
		
		
		//Call service start
		service.start();
		
		//Get schedule
		AppointmentInfo[] schedule = service.getAppointmentSchedule();
		

		
		//Begin processing requests and organize them into a new schedule
		while(getNextRequests(requestBuffer, apptReqs, service)) {
			
			while(!apptReqs.isEmpty()) {
				AppointmentRequest req = apptReqs.poll();
				//Check if schedule already contains appointment at preferred times w/ preferred doctors
				//Check if preferred times are within bounds (including flag for new patient)
				//If valid schedule time is found, add to new schedule array
			}
		}
		
		service.postSchedule(schedule);
		
		
		service.stop();		
	}
	public static boolean getNextRequests(int bufferSize, Queue<AppointmentRequest> requestQueue, SchedulingService service) {

		for(int i = 0; i < bufferSize; ++i) {
			AppointmentRequest apptReq = service.getAppointmentRequest();
			if(apptReq == null) {
				return false;
			}
			requestQueue.add(apptReq);
		}
		return true;
	}
	
}