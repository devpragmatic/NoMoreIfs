package com.devpragmatic.nomoreifs.state;

public class JuniorEmployeeState implements EmployeeState {

    public int getSalary(int rate, int daysOff, boolean likedByBoss) {
        if (isFired(rate, likedByBoss)) {
            return rate * daysOff / 2;
        }
        return rate;
    }

    public boolean isFired(int salary, boolean likedByBoss) {
        return !likedByBoss;
    }

    public boolean isIntern() {
        return false;
    }

    public boolean isEmployed() {
        return true;
    }

    public void validateRate(int rate) {
        if (rate > 1500) throw new RuntimeException();
    }
}