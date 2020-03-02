package question38;

import java.util.*;

// 输入一个字符串，打印该字符串中字符的全排列
public class Solution {
    static void solute(String str) {
        if (str == null)
            return;
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            list.add(str.charAt(i));
        }
        _solute(list, 0);
    }

    private static void _solute(ArrayList<Character> list, Integer layer) {
        if (layer == list.size()) {
            for (Character character : list) {
                System.out.print(character);
            }
            System.out.println();
        } else {
            for (int i = layer; i < list.size(); ++i) {
                Collections.swap(list, layer, i);
                _solute(list, layer + 1);
                Collections.swap(list, layer, i);
            }
        }
    }

    // 扩展：求字符串所有字符的组合
    static void solute2(String str) {
        if (str == null)
            return;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); ++i) {
            _solute2(str, 0, i + 1, list);
        }
    }

    private static void _solute2(String str, Integer first, Integer cnt, LinkedList<Character> list) {
        if (cnt == 0) {
            for (Character ch : list)
                System.out.print(ch);
            System.out.println();
        } else {
            for (int i = first; i < str.length(); ++i) {
                list.add(str.charAt(i));
                _solute2(str, i + 1, cnt - 1, list);
                list.removeLast();
            }
        }
    }

    // 扩展：输入8个数字的数组，判断有没有可能把8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等
    static void solute3(Integer[] arr) {
        if (arr == null || arr.length != 8)
            return;
        List<Integer> list = Arrays.asList(arr);
        _solute3(list, 0);
    }

    private static void _solute3(List<Integer> arr, Integer layer) {
        if (layer == 8) {
            Integer above = 0;
            for (int i = 0; i < 4; ++i) {
                above += arr.get(i);
            }
            Integer below = 0;
            for (int i = 4; i < 8; ++i) {
                below += arr.get(i);
            }
            Integer left = 0;
            for (int i = 0; i < 8; i += 2) {
                left += arr.get(i);
            }
            Integer right = 0;
            for (int i = 1; i < 8; i += 2) {
                right += arr.get(i);
            }
            Integer front = arr.get(0) + arr.get(1) + arr.get(4) + arr.get(5);
            Integer behind = arr.get(2) + arr.get(3) + arr.get(6) + arr.get(7);
            if (above.equals(below) && left.equals(right) && front.equals(behind)) {
                for (Integer v : arr) {
                    System.out.print(v);
                    System.out.print(' ');
                }
                System.out.println();
            }
        } else {
            for (int i = layer; i < arr.size(); ++i) {
                Collections.swap(arr, layer, i);
                _solute3(arr, layer + 1);
                Collections.swap(arr, layer, i);
            }
        }
    }

    // 扩展：8皇后问题
    static void solute4() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            list.add(i + 1);
        }
        _solute4(list, 0);
    }

    private static void _solute4(ArrayList<Integer> list, Integer layer) {
        if (layer == 8) {
            for (int i = 0; i < 8; ++i) {
                System.out.print(list.get(i));
                System.out.print(' ');
            }
            System.out.println();
        } else {
            for (int i = layer; i < 8; ++i) {
                Collections.swap(list, layer, i);
                boolean collision = false;
                for (int j = layer - 1; j >= 0; --j) {
                    if (_diagonalCollision(list, layer, j)) {
                        collision = true;
                        break;
                    }
                }
                if (!collision) {
                    _solute4(list, layer + 1);
                }
                Collections.swap(list, layer, i);
            }
        }
    }

    private static boolean _diagonalCollision(ArrayList<Integer> list, Integer i, Integer j) {
        return i - j == list.get(i) - list.get(j) || j - i == list.get(i) - list.get(j);
    }
}
