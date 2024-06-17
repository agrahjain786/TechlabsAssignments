package com.monocept.model;

public class SmartHome {
	
	SmartDevice[] devices = new SmartDevice[10];
    int currentNumberOfDevices = 0;
    
    public void addDevice(LightClass light) {
        devices[currentNumberOfDevices++] = light;
    }
    

    public  void addDevice(Thermostat thermostat) {
        devices[currentNumberOfDevices++] = thermostat;
    }
    

    public void addDevice(SecurityCamera securityCamera) {
        devices[currentNumberOfDevices++] = securityCamera;
    }
    
    

    public void controlDevice(String deviceID, boolean turnOn) {
    	for (int i=0;i<currentNumberOfDevices; i++) {
            if (devices[i].getDeviceID().equals(deviceID)) {
            	
            	if (devices[i] instanceof Controllable) {
					Controllable controllable = (Controllable) devices[i];
				
					if (turnOn) {
						controllable.turnOn();
						return;
					}
					controllable.turnOff();
				}

				if (devices[i] instanceof SecurityCamera) {
					SecurityCamera securityCamera = (SecurityCamera) devices[i];
					securityCamera.setRecording(turnOn);
				}
				return;
            }
     
        }
    	System.out.println("Device not found");
    }
    
    

    public void listAllDevices() {
        for (int i = 0; i < currentNumberOfDevices; i++) {
        	
        	System.out.println("Smart Device Number "+(i+1));
            SmartDevice device = devices[i];
            
            
            System.out.print("Device Id : ");
            System.out.println(device.getDeviceID());
            
            System.out.print("Device Name : ");
            System.out.println(device.getName());
            
            System.out.print("Device status : ");
            System.out.println(device.isOn());
            
            if (devices[i] instanceof Thermostat) {
				Thermostat thermostat = (Thermostat) devices[i];
				System.out.print("Temperature: ");
				System.out.println(thermostat.getTemperature());
			}
        }
    }
}
