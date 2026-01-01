public class Solution {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        Solution solve = new Solution();

        System.out.println(solve.maxArea(height));

    }
    //Time Limit Exceeded o(n^2)
    // public int maxArea(int[] height) {
    //     int max = 0;
    //     for (int left = 0; left < height.length; left ++){
    //         for (int right = height.length-1; right>=0; right--){
    //             int value = Math.min(height[left],height[right])*Math.abs(left-right); 
    //             if (value>max){
    //                 max = value; 
    //             }
                
    //         }
    //     }

    //     return max;
    // }
    
    //two pointers o(n) 5ms
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left!=right){
            int value = Math.min(height[left],height[right])*Math.abs(left-right); 
            if (value>max){
                max = value; 
            }
            if (height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}
