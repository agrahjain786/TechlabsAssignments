package com.monocept.model;

public class SecurityCamera implements SmartDevice, Monitorable{
	 private String deviceID;
	 private String name;
	 private boolean recording;
	 
	 
	public SecurityCamera(String deviceID, String name, boolean recording) {
		super();
		this.deviceID = deviceID;
		this.name = name;
		this.recording = recording;
	}


	public SecurityCamera() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getStatus() {
		return "Device is " + recording;
	}


	@Override
	public String getDeviceID() {
		return deviceID;
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public boolean isOn() {
		return recording;
	}
	 
	public void setRecording(boolean turnOn) {
		this.recording=turnOn;
	}
	
	
	
}
