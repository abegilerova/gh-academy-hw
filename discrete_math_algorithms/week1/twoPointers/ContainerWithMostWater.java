package twoPointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int currentMaxArea = 0;

        while(left < right){
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            currentMaxArea = Math.max(currentMaxArea,width * minHeight);
            if(minHeight == height[left]){
                left++;
            } else {
                right--;
            }


           // System.out.println(width);
        }

        System.out.println(currentMaxArea);
        return currentMaxArea;


    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }
}
