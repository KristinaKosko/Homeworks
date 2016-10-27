package com.company;

import java.util.Random;

/**
 *
 */
public class ServerPingEmulator {

    public Integer emulatePing() {
        return new Random().nextInt(491) + 10;
    }
}
