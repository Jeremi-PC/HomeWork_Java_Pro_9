package org.example.commandLineParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandLineParser {
    public CommandLineParser() {
    }

    public static String[] stringParser(String inputStr) {
        return inputStr.split(" ");
    }

    public static void checkCorrect(String[] outputStr) throws CheckRequriedElements, CheckValidValues, CheckOutputFile {
        int lastElement = outputStr.length;

        if (lastElement < 3) throw new CheckValidValues("Not valid output file or command not correct");
        if (outputStr[0] == null) throw new CheckValidValues("Command not correct");
        if (!outputStr[0].endsWith(".exe")) throw new CheckValidValues("invalid extension of output file");
        if (!outputStr[1].equals("-s")
                && !outputStr[1].equals("-i")
                && !outputStr[2].equals("-s")
                && !outputStr[2].equals("-i")) throw new CheckRequriedElements("Data type 's' or 'i' is required");
        else {
            for (int i = lastElement - 1; outputStr[i].contains("-"); i--) {
                if (!outputStr[i].endsWith(".txt"))
                    throw new CheckOutputFile("Input file expected");
            }
        }
    }


}




