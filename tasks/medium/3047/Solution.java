//72 ms
public class Solution {
    public static void main(String[] args) {
        int[][] bottomLeft = { { 1, 1 }, { 2, 2 }, { 3, 1 } };
        int[][] topRight = { { 3, 3 }, { 4, 4 }, { 6, 6 } };

        Solution solve = new Solution();

        System.out.println(solve.largestSquareArea(bottomLeft, topRight));

    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long m = 0;

        for (int i = 0; i < bottomLeft.length; i++) {

            int a1 = bottomLeft[i][0];
            int b1 = bottomLeft[i][1];
            int c1 = topRight[i][0];
            int d1 = topRight[i][1];

            for (int j = i + 1; j < bottomLeft.length; j++) {

                int a2 = bottomLeft[j][0];
                int b2 = bottomLeft[j][1];
                int c2 = topRight[j][0];
                int d2 = topRight[j][1];
                
                int leftX = Math.max(a1, a2);
                int rightX = Math.min(c1, c2);
                int bottomY = Math.max(b1, b2);
                int topY = Math.min(d1, d2);

                if (leftX < rightX && topY > bottomY){
                    int width = rightX - leftX;
                    int height = topY - bottomY;
                    long size = (long)Math.min(width, height);
                    m = Math.max(m, size*size);

                }
            }
        }

        return m;
    }
}
