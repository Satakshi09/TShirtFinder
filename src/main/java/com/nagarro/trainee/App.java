package com.nagarro.trainee;

import java.util.Scanner;
import java.util.Timer;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String color, size, gender, outputPreference;

		System.out.println("please enter colour");
		color = sc.next();
		System.out.println("please enter size");
		size = sc.next();
		System.out.println("please enter gender");
		gender = sc.next();
		System.out.println("please enter output preference");
		outputPreference = sc.next();
		Timer t = new Timer();

		ReadFromCsv csv = new ReadFromCsv(color, size, gender, outputPreference, t);

		t.scheduleAtFixedRate(csv, 0,  10000 *10);

	}

}