package com.devpragmatic.nomoreifs.state;

public interface EmployeeState {

    int getSalary(int rate, int daysOff, boolean likedByBoss);

    boolean isFired(int rate, boolean likedByBoss);

    boolean isIntern();

    boolean isEmployed();

    void validateRate(int rate);
}
