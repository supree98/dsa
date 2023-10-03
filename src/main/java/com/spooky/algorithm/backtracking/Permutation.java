package com.spooky.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public List<String> permutation(String s) {
        List<String> ans = new ArrayList<>();
        boolean[] taken = new boolean[s.length()];
        permutation(s, "", ans, taken);
        return ans;
    }

    private void permutation(String s, String permute, List<String> ans, boolean[] taken) {
        if (s.length() == permute.length()) {
            ans.add(permute);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!taken[i]) {
                char c = s.charAt(i);
                taken[i] = true;
                permutation(s, permute + c, ans, taken);
                taken[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABCD";
        System.out.println(new Permutation().permutation(s));
    }
}
