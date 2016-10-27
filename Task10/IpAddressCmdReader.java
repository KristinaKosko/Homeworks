package com.company;

import java.util.ArrayList;

/**
 * Reads ip-addresses from command line and checks them
 */
public class IpAddressCmdReader extends IpAddressReader {
    private String[] args;

    /**
     * Reads ip-addresses from command line
     *
     * @param args - array of parameters, entered from command line
     */
    public IpAddressCmdReader(String[] args) {
        this.args = args;
    }

    /**
     * Reads ip-addresses
     * @return - ArrayList<String>, list of ip-addresses
     */
    public ArrayList<String> readIp() {
        ArrayList<String> ipList = new ArrayList<String>();
        for (String ip : args) {
            if (validateIp(ip)) {
                ipList.add(ip);
            } else {
                System.out.println(ip + " not valid IP!");
            }
        }
        return ipList;
    }
}
