package com.monocept.model;

public class OperationStrategy implements IOperation{
	
	IOperation iOperation;
	

	public OperationStrategy(IOperation iOperation) {
		super();
		this.iOperation = iOperation;
	}

	
	@Override
	public int doOperation(int a, int b) {
		// TODO Auto-generated method stub
		return iOperation.doOperation(a, b);
	}


	public void setiOperation(IOperation iOperation) {
		this.iOperation = iOperation;
	}
	
	

}
