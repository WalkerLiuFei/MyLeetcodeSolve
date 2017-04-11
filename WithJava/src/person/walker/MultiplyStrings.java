package person.walker;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/1/5 0005.
 */
public class MultiplyStrings {
    @Test()
    public void test(){
        new MultiplyStrings().multiply("255","255");
    }
    public String multiply(String num1, String num2) {
        int[][] segments = new int[num2.length()][num1.length()];
        String[] savers = new String[num2.length()];
        String result = new String();
        for (int index2 = num2.length() -1 ;index2 >= 0;index2 --){
            int number2 = num2.charAt(index2) - 48;
            String saver = new String();
            for( int index1 = num1.length() -1; index1 >= 0; index1--){
                int number1 = num1.charAt(index1) - 48;
                segments[index2][index1] = number1 * number2;
                saver = addToSaver(saver.toCharArray(),(number1 * number2 + "").toCharArray(),num1.length() - index1 -1 );
            }

            result = addToSaver(result.toCharArray(),saver.toCharArray(),num2.length() - index2 - 1);
        }
        return result;
    }

    private String addToSaver(char[] saver, char[] number, int startIndex) {
        int carryBit = 0;
        for (int index = number.length - 1;index > 0; index --){
            int saverIndex = saver.length - 1 - startIndex - index;
            int numberElement = number[index] - 48;
            if (saverIndex < 0){
                if (carryBit == 1){
                    number[index] = (char) (numberElement + carryBit + 48);
                }
                return Arrays.toString(Arrays.copyOfRange(number,0,index+1)) + Arrays.toString(saver);
            }else {
                int saverElement = saver[saverIndex] - 48;
                carryBit =  (saverElement + numberElement) / 10 + carryBit;
                saver[saverIndex] = (char) ((saverElement + numberElement) % 10 + 48);
            }
        }
        return Arrays.toString(saver);
    }
}
