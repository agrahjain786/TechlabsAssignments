package com.monocept.model;

public class YellowState implements State {
	
    @Override
    public void change(TrafficLight context) {
        System.out.println("Traffic light turns RED.");
        context.setState(new RedState());
    }
}
