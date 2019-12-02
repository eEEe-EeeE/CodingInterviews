package question4.solution;

import question4.beans.Result;

class TwoDimFinder {
    Result findNum(Integer[][] nums, Integer key) {
        int row_len = nums.length;
        int col_len = nums[0].length;
        if (key < nums[0][0] || key > nums[row_len - 1][col_len - 1]) {
            return new Result(false, null, null);
        }
        int row_i = 0;
        int col_i = col_len - 1;
        while (row_i != row_len && col_i != -1) {
            if (nums[row_i][col_i].equals(key)) {
                return new Result(true, row_i, col_i);
            } else if (nums[row_i][col_i] < key) {
                ++row_i;
            } else if (nums[row_i][col_i] > key) {
                --col_i;
            }
        }
        return new Result(false, null, null);
    }
}
