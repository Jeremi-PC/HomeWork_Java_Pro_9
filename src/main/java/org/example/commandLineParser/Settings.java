package org.example.commandLineParser;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    private boolean isAscending;
    private String typeOfData;
    private String outputFile;
    private List<String> inputFiles;

    @Override
    public String toString() {
        return "Settings: \n" +
                " isAscending = '" + isAscending +
                "',\n typeOfData = '" + typeOfData +
                "',\n outputFile = '" + outputFile +
                "',\n inputFiles = " + inputFiles;
    }

    public Settings() {
        inputFiles = new ArrayList<>();
    }
    public static Settings makeSettingRules(List<String> inputList) {
        Settings settings = new Settings();
        settings.isAscending = true;
        settings.outputFile = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            switch (inputList.get(i)) {
                case "-i" -> settings.typeOfData = "Integer";
                case "-s" -> settings.typeOfData = "String";
                case "-a" -> settings.isAscending = true;
                case "-d" -> settings.isAscending = false;
                default -> settings.inputFiles.add(inputList.get(i));
            }
        }
        return settings;
    }
}

