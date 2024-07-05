package com.monocept.test;

import com.monocept.model.TrafficLight;

public class StateTest {
	
	public static void main(String[] args) {
        TrafficLight context = new TrafficLight();
        
        
        for (int i = 0; i < 6; i++) {
            context.change();
        }
    }

}