package com.number.restservice;

import java.util.ArrayList;

public class Interval {

    private Number start;
    private Number end;

    public Interval(Number start, Number end) {
        this.start = start;
        this.end = end;
    }

    public ArrayList<Number> findPerfectNumbers()
    {
        int index = 0;
        ArrayList<Number> findings = new ArrayList<Number>();
        for (int i = this.end.getValue() - 1; i >= this.start.getValue() ; i--) {
            Number candidate = new Number(i);
            if (candidate.isPerfect()) {
                findings.add(index, candidate);
                index++;
            }
        }
        return findings;
    }
}
