package person.walker.math;

import java.util.Map;

/**
 * Created by Administrator on 2016/11/20 0020.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] modes = new int[]{1000,100,10,1};
        String[] values = new String[]{"M","C","X","I"};
        String[] backUpValues = new String[]{"","D","L","V",""};//500,50,5
        for (int index = 0;index < modes.length;index++){
            int divideRes  = num / modes[index];
            num = num % modes[index];
            if (divideRes == 4){
                result.append(values[index]);
                result.append(backUpValues[index-1]);
            }
            if (divideRes == 9){
                result.append(values[index]);
                result.append(values[index-1]);
            }
            if(divideRes >= 5){
                result.append(backUpValues[index]);
                divideRes = divideRes - 5;
            }
            while (divideRes-- > 0){
                result.append(values[index]);
            }
        }
        return result.toString();
    }
}
