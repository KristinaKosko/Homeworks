package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parent class, reads ip-address from command line or from the file
 */
public abstract class IpAddressReader {

    /**
     * Reads ip-addresses from file or command line depending on args
     * (if args = 0 (user didn't enter something) - reads from file;
     * else (if user entered smth in command line) - reads from cmd
     *
     * @return - ArrayList<String>, list of ip-addresses
     */
    public abstract ArrayList<String> readIp();

    /**
     * Validates IP-addresses
     *
     * @param ipAddress - String, contains ip-address
     * @return - boolean, true  - if ip-address valid;
     *                    false - if ip-address is not valid
     */
    public boolean validateIp(String ipAddress) {
        String[] ipParts = ipAddress.split("\\.");
        Pattern pattern = Pattern.compile("\\.");
        int count = 0;
        Matcher matcher = pattern.matcher(ipAddress);
        while (matcher.find()) count++;
        if (count != 3) {
            return false;
        }
        if (ipParts.length != 4) {
            return false;
        }
        for (String part : ipParts) {
            if (part.startsWith("+")) {
                return false;
            }
            try {
                int intPart = Integer.parseInt(part);
                if (intPart < 0 || intPart > 255) {
                    return false;
                }
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
