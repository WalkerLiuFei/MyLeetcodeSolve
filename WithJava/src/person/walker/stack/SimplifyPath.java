package person.walker.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public class SimplifyPath {
    public static final String BACK  = "..";
    public static final String CURRENT = ".";
    public static final String SLASH = "/";
    public static StringBuilder stringBuilder = new StringBuilder();
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        stack.push("/");
        String[] strings = path.split("[/]+");
        for (String str : strings){
            if (BACK.equals(str)){
                if (stack.size() <= 1)
                  continue;
                stack.pop();
            }else if (CURRENT.equals(str) || SLASH.equals(str)|| str.length() < 1){
                continue;
            }else
                stack.push(str);
        }
        if (stack.size() == 1)
            return stack.peek();
        stringBuilder.append(stack.get(0));
        for (int index = 1;index < stack.size()-1;index++)
              stringBuilder.append(stack.get(index)).append("/");
        stringBuilder.append(stack.peek());
        return stringBuilder.toString();
    }

    @Test
    public void test(){
       System.out.println(new SimplifyPath().simplifyPath("/.../ ")); ;
    }
}
