import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };

        Solution solve = new Solution();

        System.out.println(solve.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int parent = 0;
        while (child < g.length && parent < s.length){
            if (g[child]<=s[parent]){
                child++;
            }
            parent++;
        }
        return child;
    }
}

