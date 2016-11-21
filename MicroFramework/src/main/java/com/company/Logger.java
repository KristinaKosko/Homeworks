package com.company;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Creates log-file
 */
public class Logger {

    public static final Logger Instance = new Logger();

    private StringBuilder sb;

    public double totalExecutionTime = 0;
    public int successfulTests = 0;
    public int totalTests = 0;

    private Logger()
    {
        sb = new StringBuilder();
    }

    /**
     * Creates log-file, filling it with data
     *
     * @param isSuccess - boolean, if test was executed successful or not
     * @param text - String, name of the command and it's parameters
     */
    public void Log(Boolean isSuccess, String text, double executionTime) {
        if (isSuccess) {
           sb.append("+ [" + text + "] " + Math.round(executionTime/1000000000*1000)/1000.0);
           successfulTests++;
        } else {
           sb.append("! [" + text + "] " + Math.round(executionTime/1000000000*1000)/1000.0);
        }
        totalTests++;
        totalExecutionTime += executionTime;
    }

    /**
     * Writes log-file, adds to it additional data
     *
     * @param file
     */
    public void WriteToFile(String file) {
        FileWriter writer = null;
        try {
        writer = new FileWriter(file);
        writer.write(sb.toString() + "\n"
                + "Total tests: " + totalTests + "\n"
                + "Passed/Failed: " + successfulTests + "/" + (totalTests - successfulTests) + "\n"
                + "Total time: " + Math.round(totalExecutionTime/1000000000*1000)/1000.0 + "\n"
                + "Average time: " + Math.round(totalExecutionTime/totalTests/1000000000*1000)/1000.0 + "\n");
        writer.flush();
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trivial getter of total execution time
     *
     * @return totalExecutionTime - double, time on execution of program
     */
    public double getTotalExecutionTime() {
        return totalExecutionTime;
    }
}

