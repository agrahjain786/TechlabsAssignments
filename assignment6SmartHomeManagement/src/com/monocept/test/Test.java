package com.monocept.test;

import java.util.Scanner;

import com.monocept.model.LightClass;
import com.monocept.model.SecurityCamera;
import com.monocept.model.SmartHome;
import com.monocept.model.Thermostat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
        SmartHome smartHome = new SmartHome();
        
        while(true) {
        	System.out.println("1. Add Device \n2. Control Device \n3. List all Devices \n4. Exit");
        	
        	 int choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     addDevice(scanner, smartHome);
                     break;
                 case 2:
                     System.out.println("Enter the details : ");
                     System.out.print("Enter device Id : ");
                     String deviceID = scanner.next();
                     System.out.print("Enter device status : ");
                     boolean turnOn = scanner.nextBoolean();
                     smartHome.controlDevice(deviceID, turnOn);
                     break;
                 case 3:
                     smartHome.listAllDevices();
                     break;
                 case 4:
                     return;
             }
        }

	}

	private static void addDevice(Scanner scanner, SmartHome smartHome) {
		// TODO Auto-generated method stub
		
		 System.out.println("Select:\n1. Light \n2. Thermostat \n3. Security Camera");
	        int choice = scanner.nextInt();
	        
	        switch (choice) {
	            case 1:
	            	System.out.println("you selected light");
	                LightClass light = addLight(scanner, new LightClass());
	                smartHome.addDevice(light);
	                break;
	                
	            case 2:
	            	System.out.println("you selected thermostat");
	                Thermostat thermostat = addThermostat(scanner, new Thermostat());
	                smartHome.addDevice(thermostat);
	                break;
	            case 3:
	            	
	            	System.out.println("you selected secuity camera");
	                SecurityCamera securitycamera = addSecurityCamera(scanner, new SecurityCamera());
	                smartHome.addDevice(securitycamera);
	                break;
	                
	            default:
	                System.out.println("Invalid choice, please try again.");
	        }
		
	}

	private static SecurityCamera addSecurityCamera(Scanner scanner, SecurityCamera securityCamera) {
		
		System.out.println("Enter device ID:");
		String deviceId = scanner.next();
        System.out.println("Enter name:");
        String deviceName = scanner.next();
        System.out.println("Is recording? (true for yes, false for no):");
        boolean recording = scanner.nextBoolean();
        return new SecurityCamera(deviceId, deviceName, recording);
	}

	private static LightClass addLight(Scanner scanner, LightClass lightClass) {
		System.out.print("Enter device id : ");
        String deviceId = scanner.next();
        System.out.print("Enter device name : ");
        String deviceName = scanner.next();
        System.out.println("Enter status (true for on, false for off):");
        boolean turnOn = scanner.nextBoolean();
        return new LightClass(deviceId, deviceName, turnOn);
	}

	private static Thermostat addThermostat(Scanner scanner, Thermostat thermostat) {
		System.out.println("Enter device ID:");
		String deviceId = scanner.next();
        System.out.println("Enter name:");
        String deviceName = scanner.next();
        System.out.println("Enter status (true for on, false for off):");
        boolean turnOn = scanner.nextBoolean();
        System.out.println("Enter temperature:");
        double temperature = scanner.nextDouble();
        return new Thermostat(deviceId, deviceName, turnOn, temperature);
	}

}
