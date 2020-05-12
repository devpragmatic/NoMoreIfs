package com.devpragmatic.nomoreifs.state;

import com.devpragmatic.nomoreifs.Employee;

public class EmployeeStateContext implements Employee {

    private EmployeeState employeeState = new InternEmployeeState();
    private int rate;
    private int daysOff;
    private boolean likedByBoss;

    public void promotionToIntern() {
        employeeState = new InternEmployeeState();
    }

    public void promotionToJunior() {
        employeeState = new JuniorEmployeeState();
    }

    public void likedByBoss(boolean likedByBoss) {
        this.likedByBoss = likedByBoss;
    }

    public boolean isFired() {
        return employeeState.isFired(rate, likedByBoss);
    }

    public void promotionToExpert() {
        employeeState = new ExpertEmployeeState();
    }

    public void promotionToSenior() {
        employeeState = new SeniorEmployeeState();
    }

    public void setRate(int rate) {
        employeeState.validateRate(rate);
        this.rate = rate;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public int getSalary() {
        return employeeState.getSalary(rate, daysOff, likedByBoss);
    }

    public boolean isEmployed() {
        return employeeState.isEmployed();
    }

    public boolean isIntern() {
        return employeeState.isIntern();
    }
}
