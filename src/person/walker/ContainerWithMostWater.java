package person.walker;

/**
 * beat 70.88 %.....
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int frontPointer = 0;
        int endPointer = height.length-1;
        int max = (endPointer-frontPointer) * Math.min(height[endPointer],height[frontPointer]);
        while (endPointer > frontPointer){
            int backEnd = height[endPointer];
            int frontEnd = height[frontPointer];
            int temp = Math.min(frontEnd,backEnd) * (endPointer-frontPointer);
            if (frontEnd < backEnd){
                frontPointer++;
            }else
                endPointer--;
            if (max < temp)
                max = temp;
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,1,8,9,48,18,185,1}));
    }
}
