import java.util.HashSet;
import java.util.Set;

//11ms
public class Solution {
    public static void main(String[] args) {
        int[] aSize = { 1, 2 };
        int[] bSize = { 2, 3 };

        Solution solve = new Solution();

        System.out.println(solve.fairCandySwap(aSize, bSize));
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sA = getSum(aliceSizes);
        int sB = getSum(bobSizes);
        int target = (sA - sB) / 2;

        Set<Integer> aliceSet = new HashSet<>();
        for (int candy : aliceSizes)
            aliceSet.add(candy);

        for (int b : bobSizes){
            int needTo = b + target;
            if (aliceSet.contains(needTo)){
                return new int[]{needTo, b};
            }
        }
        return null;
    }

    public int getSum(int[] arr) {
        int cnt = 0;
        for (int a : arr) {
            cnt += a;
        }
        return cnt;
    }
}
