package com.devpragmatic.nomoreifs;


import com.devpragmatic.nomoreifs.state.EmployeeStateContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new EmployeeStateContext();
    }

    @Test
    public void shouldBeIntern_whenIsNotPromoted() {
        assertTrue(employee.isIntern());
    }

    @Test
    public void shouldBeUnemployed_whenIsIntern() {
        employee.promotionToIntern();
        assertFalse(employee.isEmployed());
    }

    @Test
    public void shouldBeEmployed_whenIsJunior() {
        employee.promotionToJunior();
        assertTrue(employee.isEmployed());
    }

    @Test
    public void shouldBeEmployed_whenIsSenior() {
        employee.promotionToSenior();
        assertTrue(employee.isEmployed());
    }

    @Test
    public void shouldBeEmployed_whenIsExpert() {
        employee.promotionToExpert();
        assertTrue(employee.isEmployed());
    }

    @Test
    public void shouldNotBeFired_whenBossLikeHim_and_whenIsIntern() {
        employee.promotionToIntern();
        employee.likedByBoss(true);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldNotBeFired_whenBossDoNotLikeHim_and_whenIsIntern() {
        employee.promotionToIntern();
        employee.likedByBoss(false);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldBeFired_whenBossDoNotLikeHim_and_whenIsJunior() {
        employee.promotionToJunior();
        employee.likedByBoss(false);
        assertTrue(employee.isFired());
    }

    @Test
    public void shouldNotBeFired_whenBossLikeHim_and_whenIsJunior() {
        employee.promotionToJunior();
        employee.likedByBoss(true);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldBeFired_whenBossLikeHim_and_whenISExpert() {
        employee.promotionToExpert();
        employee.likedByBoss(false);
        assertTrue(employee.isFired());
    }

    @Test
    public void shouldBeFired_whenBossLikeHim_and_whenISExpert_and_whenRateLessThan2000() {
        employee.promotionToExpert();
        employee.likedByBoss(true);
        employee.setRate(1999);
        assertTrue(employee.isFired());
    }

    @Test
    public void shouldNotBeFired_whenBossLikeHim_and_whenIsExpert_and_whenRateEq2000() {
        employee.promotionToExpert();
        employee.likedByBoss(true);
        employee.setRate(2000);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldBeFired_whenBossLikeHim_and_whenIsExpert_and_whenRateMoreThan2000() {
        employee.promotionToExpert();
        employee.likedByBoss(true);
        employee.setRate(2001);
        assertTrue(employee.isFired());
    }

    @Test
    public void shouldNotBeFired_whenBossLikeHim_and_whenIsSenior_and_whenRateLessThan1000() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setRate(999);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldBeFired_whenBossLikeHim_and_whenIsSenior_and_whenRateEq1000() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setRate(1000);
        assertTrue(employee.isFired());
    }

    @Test
    public void shouldNotBeFired_whenBossLikeHim_and_whenIsSenior_and_whenRateMoreThan1000() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setRate(1001);
        assertFalse(employee.isFired());
    }

    @Test
    public void shouldNotHaveSalary_whenIsFired_and_whenDoNotHaveDaysOff() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setDaysOff(0);
        assertEquals(0, employee.getSalary());
    }

    @Test
    public void shouldHaveSalaryEqualsDaysOffCountedByRate_whenIsSenior_and_whenIsFired_and_whenHaveDaysOff() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setRate(1000);
        employee.setDaysOff(2);
        assertEquals(2 * 1000, employee.getSalary());
    }

    @Test
    public void shouldHaveSalaryEqualsDaysOffCountedByRateAndTwo_whenIsExpert_and_whenIsFired_and_whenHaveDaysOff() {
        employee.promotionToExpert();
        employee.likedByBoss(false);
        employee.setRate(1000);
        employee.setDaysOff(2);
        assertEquals(2 * 2 * 1000, employee.getSalary());
    }


    @Test
    public void shouldHaveSalaryEqualsDaysOffCountedByRateAndDividedBy2_whenIsJunior_and_whenIsFired_and_whenHaveDaysOff() {
        employee.promotionToJunior();
        employee.likedByBoss(false);
        employee.setRate(1000);
        employee.setDaysOff(2);
        assertEquals(2 * 1000 / 2, employee.getSalary());
    }

    @Test
    public void shouldHaveSalaryEqualsRate_whenIsSenior_and_whenIsLikedByBoss() {
        employee.promotionToSenior();
        employee.likedByBoss(true);
        employee.setRate(1001);
        assertEquals(1001, employee.getSalary());
    }

    @Test
    public void shouldHaveSalaryEqualsRate_whenIsExpert_and_whenIsLikedByBoss() {
        employee.promotionToExpert();
        employee.likedByBoss(true);
        employee.setRate(2000);
        assertEquals(2000, employee.getSalary());
    }

    @Test
    public void shouldHaveSalaryEqualsRate_whenIsJunior_and_whenIsLikedByBoss() {
        employee.promotionToJunior();
        employee.likedByBoss(true);
        employee.setRate(1000);
        assertEquals(1000, employee.getSalary());
    }

    @Test
    public void shouldNotHaveSalary_whenIsIntern() {
        employee.promotionToIntern();
        employee.setDaysOff(2);
        assertEquals(0, employee.getSalary());
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenYouSetRateMoreThan2500_and_whenIsSenior() {
        employee.promotionToIntern();
        employee.setRate(2501);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenYouSetRateMoreThan1500_and_whenIsJunior() {
        employee.promotionToIntern();
        employee.setRate(1501);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenYouSetRateMoreThan3500_and_whenIsExpert() {
        employee.promotionToIntern();
        employee.setRate(3501);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException_whenYouSetRate_and_whenIsIntern() {
        employee.promotionToIntern();
        employee.setRate(0);
    }
}
