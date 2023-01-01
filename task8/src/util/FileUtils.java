package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static String[][] readFile(String file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error");
        }
        return listTo2Arr(lines);
    }

    private static String[][] listTo2Arr(List<String> lines) {
        String[][] arrLines = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            arrLines[i] = lines.get(i).split("(\\s|[,;])+");
        }
        return arrLines;
    }

    public static void writeFile(String[][] arr) {
        try (FileWriter writer = new FileWriter("output1.txt")) {
            for (String[] strings : arr) {
                for (String elem : strings) {
                    writer.write(elem + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readFileName() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        return scn.nextLine() + ".txt";
    }
}
