package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The program receives network address servers (ip-address as x.x.x.x), simulates a survey of these servers,
 * assigning each server a random response value in the range in ms from 10ms to 500ms.
 */
public class Main {

    /**
     * Path to the working directory
     */
    private static String filePath = "C:/Users/Kristina/IdeaProjects/Task10/addresses.txt";

    /**
     * Gets IP-addresses, generates ping, creating html-table
     *
     * @param args - array of parameters, entered from command line
     */
    public static void main(String[] args) {
        IpAddressReader reader;
        HashMap<String, Integer> ipAddressMap = new HashMap<String, Integer>();
        if (args.length == 0) {
            reader = new IpAddressFileReader(filePath);
        } else {
            reader = new IpAddressCmdReader(args);
        }
        ArrayList<String> ipList = reader.readIp();
        ServerPingEmulator emulator = new ServerPingEmulator();
        int max = 0;
        for (String ip : ipList) {
            Integer ping = emulator.emulatePing();
            ipAddressMap.put(ip, ping);
            if (ping > max) {
                max = ping;
            }
        }
        HtmlBuilder builder = new HtmlBuilder();
        for (String ip : ipList) {
            int ping = ipAddressMap.get(ip);
            builder.addLine(ip, ping, ping == max);
        }
        try {
            FileWriter output = new FileWriter("IpAddresses.html");
            output.write(builder.getHtml());
            output.close();
        } catch (IOException e) {
            System.out.println("Error while writing file!");
        }
    }
}