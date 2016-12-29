package person.walker.contest;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/11 0011.
 */
public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
/*        Arrays.sort(heaters);
        Arrays.sort(houses);*/
        int[] minRange = new int[houses.length];
        Arrays.fill(minRange,Integer.MAX_VALUE);
        int maxOfMin = Integer.MIN_VALUE;
        for (int index1 = 0; index1 < houses.length;index1++){
            for (int index2 = 0;index2 < heaters.length; index2++){
                minRange[index1] = Math.min(minRange[index1],Math.abs(heaters[index2] - houses.length));
                Math.max(maxOfMin,minRange[index1]);
            }
        }
        return maxOfMin;
    }
}
