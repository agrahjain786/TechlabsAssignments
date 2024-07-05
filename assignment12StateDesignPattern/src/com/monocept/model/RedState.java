package com.monocept.model;

public class RedState implements State {
	
    @Override
    public void change(TrafficLight context) {
        System.out.println("Traffic light turns GREEN.");
        context.setState(new GreenState());
    }

}
