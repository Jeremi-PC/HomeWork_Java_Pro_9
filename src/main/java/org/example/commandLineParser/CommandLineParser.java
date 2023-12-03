package org.example.commandLineParser;

import org.example.exception.CheckOutputFileException;
import org.example.exception.CheckRequriedElementsException;
import org.example.exception.CheckValidValuesException;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParser {
    private CommandLineParser() {
    }

    public static List<String> parse(String inputStr) throws CheckRequriedElementsException, CheckValidValuesException, CheckOutputFileException {

        String[] arrArgs = inputStr.split(" ");
        List<String> flags = new ArrayList<>();
        List<String> files = new ArrayList<>();

        for (String el : arrArgs) {
            if ("-i".equals(el) || "-s".equals(el) || "-a".equals(el) || "-d".equals(el)) {
                flags.add(el);
            } else files.add(el);
        }
        if (!files.get(0).endsWith(".exe")) throw new CheckOutputFileException("Output file is absent");
        files.removeIf(el -> !el.endsWith(".exe") && !el.endsWith(".txt"));
        if (!flags.contains("-s") && !flags.contains("-i")) {
            throw new CheckRequriedElementsException("Data type 's' or 'i' is required");
        }
        if (files.size() < 2) throw new CheckValidValuesException("You must add file's names");
        List<String> resultSettings = new ArrayList<>(files);
        resultSettings.addAll(flags);
        return resultSettings;
    }
}




