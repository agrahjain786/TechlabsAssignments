package com.monocept.test;

import com.monocept.model.AddOperation;
import com.monocept.model.MultiplyOperation;
import com.monocept.model.OperationStrategy;

public class StrategyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OperationStrategy operationStrategy = new OperationStrategy(new AddOperation());
		
		System.out.println("Add operation: "+ operationStrategy.doOperation(10, 20));
		
		operationStrategy.setiOperation(new MultiplyOperation());
		
		System.out.println("Multiply operation: "+ operationStrategy.doOperation(10, 20));

	}

}
