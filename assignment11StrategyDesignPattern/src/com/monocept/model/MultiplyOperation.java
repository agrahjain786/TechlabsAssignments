package com.monocept.model;

public class MultiplyOperation implements IOperation{

	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Multiply operation";
	}

}