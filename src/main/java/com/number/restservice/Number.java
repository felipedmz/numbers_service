package com.number.restservice;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Number {

	private int value;

	public Number(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isPerfect() {
		if (this.value < 1)
			return false;
		if (this.value % 2 > 0)
			return false;
		
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		for (int i = this.value - 1; i > 0; i--) {
			if (this.value % i == 0) {
				divisors.add(i);
			}
		}

		int sum = divisors.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("SUM: "+sum);
		System.out.println("value: "+this.value);
		return this.value == sum;
	}
}
