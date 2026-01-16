class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double bottom = Double.MAX_VALUE;
        double top = Double.MIN_VALUE;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            
            totalArea += l * l;
            
            bottom = Math.min(bottom, y);
            top = Math.max(top, y + l);
        }
        
        double halfArea = totalArea / 2.0;
        
        for (int i = 0; i < 100; i++) {
            double mid = bottom + (top - bottom) / 2.0;
            
            if (calculateArea(squares, mid) >= halfArea) {
                top = mid;
            } else {
                bottom = mid; 
            }
        }
        
        return bottom;
    }

    private double calculateArea(int[][] squares, double yCut) {
        double area = 0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;
            double bottom = y;

            if (bottom >= yCut) {
                continue;
            } else if (top <= yCut) {
                area += l * l;
            } else {
                double heightBelowCut = yCut - bottom;
                area += l * heightBelowCut;
            }
        }
        return area;
    }
}