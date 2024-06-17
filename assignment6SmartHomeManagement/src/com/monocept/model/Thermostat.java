package com.monocept.model;

public class Thermostat implements SmartDevice, Controllable, Monitorable{
	
	private String deviceID;
    private String name;
    private boolean on;
    private double temperature;
    
    
	public Thermostat(String deviceID, String name, boolean on, double temperature) {
		super();
		this.deviceID = deviceID;
		this.name = name;
		this.on = on;
		this.temperature = temperature;
	}


	public Thermostat() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getStatus() {
		return "Device is " + on;
	}


	@Override
	public void turnOn() {
		on=true;
	}


	@Override
	public void turnOff() {
		on=false;
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
		return on;
	}


	public double getTemperature() {
		return temperature;
	}
    
    
}
