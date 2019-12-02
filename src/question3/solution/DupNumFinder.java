package question3.solution;

import question3.beans.Result;

class DupNumFinder {
    public Result findDuplicate(Integer[] nums) {
        for (Integer i = 0; i < nums.length; ++i) {
            if (!nums[i].equals(i)) {
                if (nums[nums[i]].equals(nums[i])) {
                    return new Result(true, nums[i]);
                } else {
                    nums[i] ^= nums[nums[i]];
                    nums[nums[i]] ^= nums[i];
                    nums[i] ^= nums[nums[i]];
                }
            }
        }
        return new Result(false, null);
    }

    Result findDuplicate2(Integer[] nums) {
        // start end 表示的是整数范围，不是索引
        Integer start = 1;
        Integer end = nums.length - 1;
        Integer mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (rangeNum(nums, start, mid) > (mid - start + 1)) {
                if (start.equals(end)) {
                    return new Result(true, start);
                }
                end = mid;
            } else if (rangeNum(nums, mid + 1, end) > (end - mid)) {
                if (start.equals(end)) {
                    return new Result(true, start);
                }
                start = mid + 1;
            }
        }
        return new Result(false, null);
    }

    private Integer rangeNum(Integer[] nums, Integer start, Integer end) {
        Integer cnt = 0;
        for (Integer n : nums) {
            if (start <= n && n <= end) {
                ++cnt;
            }
        }
        return cnt;
    }
}

