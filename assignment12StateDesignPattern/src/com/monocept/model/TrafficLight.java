package com.monocept.model;

public class TrafficLight {
	
	private State state;

    public TrafficLight() {
        state = new RedState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void change() {
        state.change(this);
    }

}