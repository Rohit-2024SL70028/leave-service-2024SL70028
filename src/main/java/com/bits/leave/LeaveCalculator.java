
package com.bits.leave;

//Additional comment BITS ID: 2024SL70028

public class LeaveCalculator {

    // Calculate remaining leave balance
    public static int calculateLeaveBalance(
            int totalLeaves, int usedLeaves) {

        if (totalLeaves < 0 || usedLeaves < 0) {
            throw new IllegalArgumentException(
                "Leave values cannot be negative");
        }

        if (usedLeaves > totalLeaves) {
            throw new IllegalArgumentException(
                "Used leaves cannot exceed total leaves");
        }

        return totalLeaves - usedLeaves;
    }

    // Calculate leave encashment amount
    public static double calculateLeaveEncashment(
            int encashableDays, double dailySalary) {

        if (encashableDays < 0 || dailySalary < 0) {
            throw new IllegalArgumentException(
                "Values cannot be negative");
        }

        return encashableDays * dailySalary;
    }
}
