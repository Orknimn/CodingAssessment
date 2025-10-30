package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpRequest.BodyPublishers;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.AppointmentRequest;
import models.AppointmentInfo;
import util.DotenvKeyReader;

public class SchedulingService {
	DotenvKeyReader keyReader;
	String baseUrl;
	String key;
	Gson gson;
	public SchedulingService() {
		this.keyReader = new DotenvKeyReader();
		this.baseUrl = "https://scheduling.interviews.brevium.com/api/Scheduling/";
		this.key = keyReader.getAPIKey();
		this.gson = new Gson();
	}
	public void start() {
		String apiUrl = this.baseUrl + "Start?token=" + this.key;
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(URI.create(apiUrl)).POST(BodyPublishers.noBody()).build();
			HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
			int responseCode = res.statusCode();
			String message;
			switch (responseCode) {
				case 200: {
					message = "Scheduler Started.";
					break;
				}
				case 401: {
					message = "Token invalid: Schedular Not Started.";
					break;
				}
				case 404: {
					message = "Request not found";
					break;
				}
				default: {
					message = "Unknown error occurred. Response Code: " + responseCode;
				}
				
			}
			
			System.out.println(message);
			
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void stop() {
		String apiUrl = this.baseUrl + "Stop?token=" + this.key;
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(URI.create(apiUrl)).POST(BodyPublishers.noBody()).build();
			HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
			int responseCode = res.statusCode();
			String message;
			switch (responseCode) {
				case 200: {
					message = "Scheduler Stopped.";
					break;
				}
				case 401: {
					message = "Token invalid: Schedular Not Stopped.";
					break;
				}
				case 404: {
					message = "Request not found";
					break;
				}
				default: {
					message = "Unknown error occurred. Response Code: " + responseCode;
				}
				
			}
			
			System.out.println(message);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public AppointmentRequest getAppointmentRequest() {
		String apiUrl = this.baseUrl + "AppointmentRequest?token=" + this.key;
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();
			HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

			if(res.statusCode() == 200) {
				AppointmentRequest appointmentReq = this.gson.fromJson(res.body(), AppointmentRequest.class);
				return appointmentReq;
			}
			//Handle specific cases and messaging
			else {
				return null;
			}
			
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	public AppointmentInfo[] getAppointmentSchedule() {
		String apiUrl = this.baseUrl + "Schedule?token=" + this.key;
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest req = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();
			HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
			Type infoListType = new TypeToken<List<AppointmentInfo>>() {}.getType();
			List<AppointmentInfo> schedule = this.gson.fromJson(res.body(), infoListType);
			System.out.println(res.body());
			return schedule.toArray(new AppointmentInfo[0]);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void postSchedule(AppointmentInfo[] schedule) {
		
	}
	
}
