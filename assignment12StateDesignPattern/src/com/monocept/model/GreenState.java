package com.monocept.model;

public class GreenState implements State {
	
    @Override
    public void change(TrafficLight context) {
        System.out.println("Traffic light turns YELLOW.");
        context.setState(new YellowState());
    }
}
