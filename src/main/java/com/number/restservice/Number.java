package com.number.restservice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {

	private BigInteger value;

	public Number(BigInteger value) {
		this.value = value;
	}

	public BigInteger getValue() {
		return this.value;
	}

	public boolean isPerfect() {
		BigInteger two = new BigInteger("2");

		if (this.value.compareTo(BigInteger.ONE) == -1 )
			return false;
		if (this.value.mod(two).compareTo(BigInteger.ZERO) == 1)
			return false;
		
		ArrayList<BigInteger> divisors = new ArrayList<BigInteger>();
		
		for (BigInteger i = this.value; i.compareTo(BigInteger.ZERO) == 1; i.subtract(BigInteger.ONE)) {
			if (this.value.mod(i).compareTo(BigInteger.ZERO) == 0)
				divisors.add(i);
		}

		int sum = divisors.stream()
			.mapToInt(BigInteger::intValue)
			.sum();

		return this.value.equals(sum);
	}
}
