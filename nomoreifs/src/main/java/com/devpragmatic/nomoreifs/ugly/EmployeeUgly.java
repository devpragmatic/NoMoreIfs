package com.devpragmatic.nomoreifs.ugly;

import com.devpragmatic.nomoreifs.Employee;

public class EmployeeUgly implements Employee {

    enum Position {
        SENIOR,
        JUNIOR,
        EXPERT,
        INTERN
    }

    private int rate;
    private int daysOff;
    private boolean likedByBoss;
    private Position position = Position.INTERN;

    public void promotionToIntern() {
        position = Position.INTERN;
    }

    public void promotionToJunior() {
        position = Position.JUNIOR;
    }

    public void likedByBoss(boolean likedByBoss) {
        this.likedByBoss = likedByBoss;
    }

    public boolean isFired() {
        if (position == Position.INTERN) {
            return false;
        }
        if (position == Position.EXPERT) {
            return !likedByBoss || rate != 2000;
        }
        if (position == Position.JUNIOR) {
            return !likedByBoss;
        }
        if (position == Position.SENIOR) {
            return !likedByBoss || rate == 1000;
        }
        return false;
    }

    public void promotionToExpert() {
        position = Position.EXPERT;
    }

    public void promotionToSenior() {
        position = Position.SENIOR;
    }

    public void setRate(int rate) {
        if (rate > getMaxRate()) {
            throw new RuntimeException();
        }
        this.rate = rate;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int getSalary() {
        if (Position.INTERN == position) {
            return 0;
        }
        if (!isFired()) {
            return rate;
        }
        if (Position.EXPERT == position) {
            return rate * 2 * daysOff;
        }
        if (Position.JUNIOR == position) {
            return rate * daysOff / 2;
        }
        return rate * daysOff;
    }

    public boolean isEmployed() {
        return position != Position.INTERN;
    }

    public boolean isIntern() {
        return position == Position.INTERN;
    }

    private int getMaxRate() {
        switch (position) {
            case EXPERT:
                return 3500;
            case JUNIOR:
                return 1500;
            case SENIOR:
                return 2500;
        }
        throw new RuntimeException();
    }
}