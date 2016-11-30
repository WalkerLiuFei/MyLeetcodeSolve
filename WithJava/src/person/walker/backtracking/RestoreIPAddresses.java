package person.walker.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(s, result, builder, 0);
        return result;
    }

    private void dfs(String restString, List<String> result, StringBuilder builder, int currentLength) {
        if (restString.length() + currentLength < 4) //剩余字符串的长度不足以形成一个有效的IP 地址
            return;
        if (currentLength == 3 && (restString.length() < 4 && Integer.parseInt(restString) <= 255)) {
            if (restString.length() >1 && restString.startsWith("0"))
                return;
            StringBuilder stringBuilder = new StringBuilder(builder);
            String value = stringBuilder.append(restString).toString();
            result.add(value);
            return;
        } else if (currentLength >= 3) //不满的情况，>= 3，大于 255 ||
            return;
        int limit = Math.min(3, restString.length());
        for (int index = 1; index <= limit; index++) {
            String sub = restString.substring(0, index);
            if (sub.startsWith("0") && sub.length() > 1)
                continue;
            if (index == 3 && (sub.length() > 3 || Integer.parseInt(sub) > 255))
                continue;
            builder.append(sub);
            builder.append(".");
            dfs(restString.substring(index, restString.length()), result, builder, currentLength + 1);    //剪切第0个字符
            builder.delete(builder.length() - index - 1, builder.length());
        }
    }

/*    private boolean isValid(String stringBuilder) {
        String[] ips = stringBuilder.split(".");
        if (ips[0].startsWith("0") && ips.length)
            return false
        return false;
    }*/

    public static void main(String[] args) {
        new RestoreIPAddresses().restoreIpAddresses("25525511135");
    }
}
