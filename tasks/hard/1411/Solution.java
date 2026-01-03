//3ms

public class Solution {
    public static void main(String[] args) {
        int nums = 3;

        Solution solve = new Solution();

        System.out.println(solve.numOfWays(nums));
    }

    private static final int MOD = 1_000_000_007;
    
    public int numOfWays(int n) {
        long typeA = 6; 
        long typeB = 6; 
        for (int i=2; i<=n; i++){
            long newTypeA =( 2 * typeA + 2 * typeB) % MOD;
            long newTypeB = (2 * typeA + 3 * typeB) % MOD;
            typeA = newTypeA;
            typeB = newTypeB;
        }
        return (int)((typeA + typeB) % MOD);
    }

}
