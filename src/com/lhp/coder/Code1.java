package com.lhp.coder;

/**
 * int array[][]={{1,2,3},
 * {4,5,6},
 * {7,8.9}}
 */
public class Code1 {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code1 code1 = new Code1();
        int target = 22;
        int array[][] ={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(code1.Find(target,array));
    }
}
