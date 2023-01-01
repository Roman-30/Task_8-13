package tests;

import logic.ArrayConvertor;
import org.junit.Assert;
import org.junit.Test;
import util.FileUtils;

public class ArrayConvertorTest {

    @Test
    public void removeDuplicateRowAndColumn1() {
        String fName = "input1.txt";
        String[][] inputData = FileUtils.readFile(fName);
        String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
        String[][] testData = {{"4", "5"}, {"2", "2"}};
        for (int i = 0; i < testData.length; i++) {
            Assert.assertArrayEquals(testData[i], outputData[i]);
        }
    }

    @Test
    public void removeDuplicateRowAndColumn2() {
        String fName = "input2.txt";
        String[][] inputData = FileUtils.readFile(fName);
        String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
        String[][] testData = {{"1", "1", "2"}, {"2", "2", "2"}, {"2", "2", "2"}};
        for (int i = 0; i < testData.length; i++) {
            Assert.assertArrayEquals(testData[i], outputData[i]);
        }
    }

    @Test
    public void removeDuplicateRowAndColumn3() {
        String fName = "input3.txt";
        String[][] inputData = FileUtils.readFile(fName);
        String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
        String[] testData = {};
        Assert.assertArrayEquals(testData, outputData);
    }

    @Test
    public void removeDuplicateRowAndColumn4() {
        String fName = "input4.txt";
        String[][] inputData = FileUtils.readFile(fName);
        String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
        String[][] testData = {{"2"}};
        for (int i = 0; i < testData.length; i++) {
            Assert.assertArrayEquals(testData[i], outputData[i]);
        }
    }

    @Test
    public void removeDuplicateRowAndColumn5() {
        String fName = "input5.txt";
        String[][] inputData = FileUtils.readFile(fName);
        String[][] outputData = ArrayConvertor.removeDuplicateRowAndColumn(inputData);
        String[][] testData = {{"3", "4", "1", "9"}, {"1", "2", "4", "1"}};
        for (int i = 0; i < testData.length; i++) {
            Assert.assertArrayEquals(testData[i], outputData[i]);
        }
    }
}