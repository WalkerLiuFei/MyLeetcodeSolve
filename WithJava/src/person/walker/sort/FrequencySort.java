package person.walker.sort;

import java.util.*;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
//#451 ,beat 84 % solutions!
public class FrequencySort {

    public String frequencySort(String s) {
        if (null == s || 0 == s.length() )
            return s;
        char[] array = s.toCharArray();

        Arrays.sort(array);

        List<StringBuilder> elements = new ArrayList<StringBuilder>();
        elements.add(new StringBuilder().append(array[0]));
        for (int index = 1;index < array.length;index++){
            char c = array[index];
            StringBuilder strBuilder = elements.get(0);
            if (strBuilder.charAt(0) == c)
                strBuilder.append(c);
            else
                elements.add(0,new StringBuilder().append(c));
        }

        Collections.sort(elements, new Comparator<StringBuilder>() {
            public int compare(StringBuilder o1, StringBuilder o2) {
                return o2.length() - o1.length();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder element : elements)
            stringBuilder.append(element);

        return stringBuilder.toString();
    }
}
