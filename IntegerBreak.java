package com.company;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * number 343, beat 39.81%..
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n==3)
            return 2;
        int excess = 1;
        if ((n-4) % 3 == 0){
            excess = 4;
            n -= 4;
        }
        int count2 = 0;
        int count3 = 0;
        count3 = n / 3;
        n = n % 3;
        count2 = n / 2;
        n = n % 2;

        return (int) (Math.pow(2,count2) * Math.pow(3,count3)*excess);
    }
}
