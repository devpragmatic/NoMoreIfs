package com.devpragmatic.nomoreifs.state;

public class InternEmployeeState implements EmployeeState {
    public int getSalary(int rate, int daysOff, boolean likedByBoss) {
        return 0;
    }

    public boolean isFired(int salary, boolean likedByBoss) {
        return false;
    }

    public boolean isIntern() {
        return true;
    }

    public boolean isEmployed() {
        return false;
    }

    public void validateRate(int rate) {
        throw new RuntimeException();
    }
}
