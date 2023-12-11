package org.example.test;
import org.example.commandLineParser.CommandLineParser;
import org.example.exception.CheckOutputFileException;
import org.example.exception.CheckRequriedElementsException;
import org.example.exception.CheckValidValuesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineParserTest {

    @Test
    public void testParseValidInput() {
        String input = "-i file1.exe -s file2.txt -a file3.exe";
        assertDoesNotThrow(() -> {
            CommandLineParser.parse(input);
        });
    }

    @Test
    public void testParseMissingOutputFileException() {
        String input = "- i -a file3.txt";
        assertThrows(CheckOutputFileException.class, () -> {
            CommandLineParser.parse(input);
        });
    }

    @Test
    public void testParseMissingRequiredElementException() {
        String input = "file1.exe file2.txt file3.txt";
        assertThrows(CheckRequriedElementsException.class, () -> {
            CommandLineParser.parse(input);
        });
    }

    @Test
    public void testParseInvalidValuesException() {
        String input = "-i file1.exe";
        assertThrows(CheckValidValuesException.class, () -> {
            CommandLineParser.parse(input);
        });
    }



}
