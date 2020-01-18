package com.number.restservice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Number {

	private final BigInteger value;

	public Number(final BigInteger value) {
		this.value = value;
	}

	public BigInteger getValue() {
		return this.value;
	}

	public boolean isPerfect() {
		final BigInteger two = new BigInteger("2");

		if (this.value.compareTo(BigInteger.ONE) == -1 )
			return false;
		if (this.value.mod(two).compareTo(BigInteger.ZERO) == 1)
			return false;
		
		final ArrayList<Integer> divisors = new ArrayList<Integer>();
		
		for (final BigInteger i = this.value; i.compareTo(BigInteger.ZERO) == 1; i.subtract(BigInteger.ONE)) {
			if (this.value.mod(i).compareTo(BigInteger.ZERO) == 0)
				divisors.add(i.intValue());
		}

		final int sum = divisors.stream()
			.collect(Collectors.summingInt(Integer::intValue));

		return this.value.equals(sum);
	}
}
