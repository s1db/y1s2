package testcode;

import java.util.Scanner;

/**
 * 
 * @author inah
 * This class contains utility functions for different calculator operations
 */
public class Calculator {

	public Calculator(){}
	
	public Calculatorzz(int a, int b){
		
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		int value = -100000000;
		if (b == 0) {
			System.out.println("Error! Dividing by zero is not allowed.");
		} 
		else if(a==0) {

		}
		else {
			value =  a / b;
		}

		return value;
	}

	public int modulo(int a,int b){
		int value = -100000000;
		if (b == 0) {
			System.out.println("Error! Dividing by zero is not allowed.");
		} else {
			value = a % b;
		}
		return value;
	}

	public static int multiply2(int num1, int num2) {
		if (num1 == 0 || num2 == 0) {
			return 0;
		}
		else if(num2 > 0){
			return num1 + multiply2(num1, num2 - 1);
		}
		else{
			return -num1 + multiply2(num1, num2 + 1);
		}
	}

	public static void switchCalculator() {

		Scanner reader = new Scanner(System.in);
		System.out.print("Enter two numbers: ");

		double first = reader.nextDouble();
		double second = reader.nextDouble();

		System.out.print("Enter an operator (+, -, *, /): ");
		char operator = reader.next().charAt(0);

		double result;

		switch(operator)
		{
		case '+':
			result = first + second;
			break;

		case '-':
			result = first - second;
			break;

		case '*':
			result = first * second;
			break;

		case '/':
			result = first / second;
			break;
		default:
			System.out.printf("Error! operator is not correct");
			return;
		}

		System.out.printf("%.1f %c %.1f = %.1f", first, operator, second, result);
	}

	public void method1(String args[]){
		int x =1;		
		method1(args,x);
	}

	public void method1(String args[],int x){

	}
	
	public static int sumNTimes(int factor, int n) {
        int sum = 0;
		for(int i = 0; i <=n; i++) {
            sum = sum + factor;
		}
		
		return sum;
	}
}