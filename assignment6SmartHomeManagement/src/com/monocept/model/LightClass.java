package com.monocept.model;

public class LightClass implements SmartDevice, Controllable{
	
	private String deviceID;
    private String name;
    private boolean on;
    

	public LightClass(String deviceID, String name, boolean on) {
		super();
		this.deviceID = deviceID;
		this.name = name;
		this.on = on;
	}

	public LightClass() {
		// TODO Auto-generated constructor stub
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
	
	
}
