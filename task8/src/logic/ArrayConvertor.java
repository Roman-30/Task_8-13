package logic;

import java.util.ArrayList;
import java.util.List;

public class ArrayConvertor {
    public static String[][] removeDuplicateRowAndColumn(String[][] inputArray) {
        List<String[]> rows = new ArrayList<>();
        for (String[] value : inputArray) {
            int iter = 0;
            for (String s : value) {
                if (value[0].equals(s)) {
                    iter++;
                }
            }
            if (iter != value.length) {
                rows.add(value);
            }
        }

        for (int j = 0; j < inputArray[0].length; j++) {
            int iter = 0;
            for (String[] string : inputArray) {
                if (inputArray[0][j].equals(string[j])) {
                    iter++;
                }
            }

            if (iter == inputArray.length) {
                for (int i = 0; i < rows.size(); i++) {
                    List<String> cur = new ArrayList<>();
                    String[] arrRow = rows.get(i);
                    for (int k = 0; k < arrRow.length; k++) {
                        if (k != j - (inputArray[0].length - arrRow.length)) {
                            cur.add(arrRow[k]);
                        }
                    }
                    rows.set(i, listToArr(cur));
                }
            }
        }

        String[][] ss = new String[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            ss[i] = rows.get(i);
        }
        return ss;
    }


    private static String[] listToArr(List<String> list) {
        String[] outList = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            outList[i] = list.get(i);
        }
        return outList;
    }

}
