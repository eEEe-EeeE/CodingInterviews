package question4.solution;

import question4.beans.Result;

public class Main {
    public static void main(String[] args) {
        Integer[][] a = new Integer[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        TwoDimFinder dimFinder = new TwoDimFinder();
        Integer key = 7;
        Result r = dimFinder.findNum(a, key);
        System.out.println(r.getFound());
        System.out.println(r.getRow());
        System.out.println(r.getCol());
    }
}
