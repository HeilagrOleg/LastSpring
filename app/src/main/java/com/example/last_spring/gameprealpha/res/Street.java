package com.example.last_spring.gameprealpha.res;

public class Street {

    private int complexity;
    private int distance;
    private String firstIntersection;
    private String secondIntersection;

    public Street(int complexity, int distance, String firstIntersection, String secondIntersection) {
        this.complexity = complexity;
        this.distance = distance;
        this.firstIntersection = firstIntersection;
        this.secondIntersection = secondIntersection;
    }

    public int getComplexity() {
        return complexity;
    }

    public int getDistance() {
        return distance;
    }

    public String getFirstIntersection() {
        return firstIntersection;
    }

    public String getSecondIntersection() {
        return secondIntersection;
    }
}
