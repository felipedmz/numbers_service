package com.number.restservice;

import java.util.ArrayList;

public class Interval {

    private int start;
    private int end;

	public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public ArrayList<Number> findPerfectNumbers()
    {
        int index = 0;
        ArrayList<Number> findings = new ArrayList<Number>();
        for (int i = this.end - 1; i >= this.start ; i--) {
            Number candidate = new Number(i);
            if (candidate.isPerfect()) {
                findings.add(index, candidate);
                index++;
            }
        }
        return findings;
    }
}
