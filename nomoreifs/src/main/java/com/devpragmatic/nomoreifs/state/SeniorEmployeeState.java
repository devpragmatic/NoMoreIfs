package com.devpragmatic.nomoreifs.state;

public class SeniorEmployeeState implements EmployeeState {

    public int getSalary(int rate, int daysOff, boolean likedByBoss) {
        if (isFired(rate, likedByBoss)) {
            return daysOff * rate;
        }
        return rate;
    }

    public boolean isFired(int salary, boolean likedByBoss) {
        return salary == 1000 || !likedByBoss;
    }

    public boolean isIntern() {
        return false;
    }

    public boolean isEmployed() {
        return true;
    }

    public void validateRate(int rate) {
        if (rate > 2500) throw new RuntimeException();
    }
}