package org.example.commandLineParser;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//1 Напишите класс CommandLineParser. Парсер должен принять аргументы командной строки,
// переданных в программу и превратить их в экземпляр класса настройки некой сортировки по следующим правилам:
//a. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//b. тип данных (-s или -i), обязательный;
//c. имя выходного файла, обязательное;
//d. остальные параметры – имена входных файлов, не менее одного.
// Примеры запуска из командной строки для Windows:
// sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию)
// sort-it.exe -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)
// sort-it.exe -d -s out.txt in1.txt in2.txt (для строк по убыванию)

//2 Если переданы неправильные данные, то парсер должен выбросить собственное checked-исключение.

//3 В основной программе создайте экземпляр парсера и
// передайте ему аргументы командной строки запуска программы.
// Обработайте необходимые исключения.
public class Main {
    public static void main(String[] args) {
        System.out.println("Pls input command: ");
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();


        CommandLineParser commandLineParser = new CommandLineParser();
        CommandLineParser.stringParser(inputStr);

        System.out.println(Arrays.toString(CommandLineParser.stringParser(inputStr)));
        try {
            String[] outputStr = CommandLineParser.stringParser(inputStr);
            CommandLineParser.checkCorrect(outputStr);
        } catch (CheckValidValues e) {
            System.out.println("Not valid output file or command not correct");
        } catch (CheckRequriedElements e) {
            System.out.println("Data type 's' or 'i' is required");
        } catch (CheckOutputFile e) {
            System.out.println("Input file expected");
        }


    }
}