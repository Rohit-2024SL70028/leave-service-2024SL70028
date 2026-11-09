
package com.bits.leave;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeaveCalculatorTest {

    // Test 1: Leave balance calculation
    @Test
    public void testLeaveBalance() {

        int balance =
            LeaveCalculator.calculateLeaveBalance(30, 10);

        assertEquals(20, balance);
    }

    // Test 2: Leave encashment calculation
    @Test
    public void testLeaveEncashment() {

        double amount =
            LeaveCalculator.calculateLeaveEncashment(5, 1000);

        assertEquals(5000.0, amount, 0.01);
    }

    // Test 3: Invalid leave balance
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLeaveBalance() {

        LeaveCalculator.calculateLeaveBalance(10, 15);
    }
}

