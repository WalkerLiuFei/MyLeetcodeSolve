package person.walker.contest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/11 0011.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        } else if (isIPv6(IP))
            return "IPv6";
        return "Neither";
    }

    public boolean isIPv4(String IP) {
        if (!IP.contains("."))
            return false;
        if (IP.charAt(IP.length() - 1) == '.'){
            return false;
        }
        for (int index = 0;index < IP.length();index++){
            char c = IP.charAt(index);
            if (!((c >= 48 && c <= 57) || c == '.') )
                return false;

        }
        IP = IP.replace(".","&");
        String[] ips = IP.split("&");
        if (ips.length != 4)
            return false;
        for (int index = 0; index < 4;index++){
            if (ips[index].length() > 3)
                return false;
            if (ips[index].length() > 1 && ips[index] .startsWith("0"))
                return false;
            if (ips[index].equals(""))
                return false;
            if(Integer.parseInt(ips[index]) > 255)
                return false;
        }
        return true;
    }

    public boolean isIPv6(String IP) {
        if (!IP.contains(":"))
            return false;
        if (IP.charAt(IP.length() - 1) == ':'){
            return false;
        }
        for (int index = 0;index < IP.length();index++){
            char c = IP.charAt(index);
            if (!((c >= 48 && c <= 57) || (c >= 65 && c <= 70) || (c >= 97 && c <= 102) || c == ':'))
                return false;
        }
        String[] ips = IP.split(":");
        if (ips.length > 8)
            return false;
        boolean flag = false;
        for (int index = 0; index < ips.length ;index++){
            if (ips[index].length() > 4){
                return false;
            }
            if (ips[index].equals("")){
                if (flag)
                    return false;
                if ((index > 0&& ips[index-1].equals("0")) || (index < ips.length -1 && ips[index+1].equals("0")))
                    return false;
                flag = true;
            }
        }
        if (!flag && ips.length != 8)
            return false;
        return true;
    }
}