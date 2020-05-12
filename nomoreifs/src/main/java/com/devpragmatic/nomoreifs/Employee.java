package com.devpragmatic.nomoreifs;


public interface Employee {

    void promotionToIntern();

    void promotionToJunior();

    void likedByBoss(boolean likedByBoss);

    boolean isFired();

    void promotionToExpert();

    void promotionToSenior();

    void setRate(int rate);

    void setDaysOff(int daysOff);

    int getSalary();

    boolean isEmployed();

    boolean isIntern();
}