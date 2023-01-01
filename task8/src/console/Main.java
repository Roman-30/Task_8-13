package console;

import logic.ArrayConvertor;
import util.FileUtils;

import static util.ArrayUtils.printArray;
import static util.FileUtils.readFileName;

public class Main {
    public static void main(String[] args) {
        String fName = readFileName();
        String[][] inputData = FileUtils.readFile(fName);
        if (inputData.length > 0) {
            System.out.print("\nВходные данные: \n" + printArray(inputData));
            String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
            System.out.print("\nВыходные данные: \n" + printArray(outputData));
            FileUtils.writeFile(outputData);
        } else {
            System.out.println("Файл пустой!");
        }
    }


}
