package gui;

import util.JTableUtils;
import util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static logic.ArrayConvertor.removeDuplicateRowAndColumn;
import static util.FileUtils.readFile;
import static util.FileUtils.writeFile;

public class MainWindow extends JFrame {

    private JTable inputTable;
    private JTable outputTable;
    private JButton openFileButton;
    private JButton calculateButton;
    private JButton saveInFileButton;
    private JPanel mainPanel;

    public MainWindow() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.setMinimumSize(new Dimension(400, 400));
        this.setVisible(true);

        saveInFileButton.setEnabled(false);

        JTableUtils.initJTableForArray(inputTable, 35, true, true,
                true, true);
        inputTable.setRowHeight(35);
        JTableUtils.initJTableForArray(outputTable, 35, true, true,
                true, true);
        outputTable.setRowHeight(35);

        openFileButton.addActionListener(e -> {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileOpen.getSelectedFile();
                String[][] strings = readFile(String.valueOf(file.getAbsoluteFile()));
                saveInFileButton.setEnabled(false);
                JTableUtils.writeArrayToJTable(outputTable, new String[][]{{}});
                JTableUtils.writeArrayToJTable(inputTable, strings);
            }
        });

        calculateButton.addActionListener(e -> {
            String[][] forTable = JTableUtils.readStringMatrixFromJTable(inputTable);
            if (forTable != null) {
                if (forTable.length != 0) {
                    JTableUtils.writeArrayToJTable(outputTable, removeDuplicateRowAndColumn(forTable));
                    saveInFileButton.setEnabled(true);
                } else {
                    SwingUtils.showInfoMessageBox("Input table is empty!");
                }
            }
        });

        saveInFileButton.addActionListener(e -> {
            String[][] forTable = JTableUtils.readStringMatrixFromJTable(outputTable);
            if (forTable != null) {
                writeFile(forTable);
                SwingUtils.showInfoMessageBox("Data saved!");
            } else {
                SwingUtils.showInfoMessageBox("Output table is empty!");
            }
        });
    }
}
