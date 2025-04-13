package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static  int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        Stack<Integer> days = new Stack<>();


        for (int i = 0; i < temperatures.length; i++){
            while(!days.isEmpty() && temperatures[i]> temperatures[days.peek()]){
                System.out.println("i + " + i);
                System.out.println("peek " + days.peek());
                int prevIndex = days.pop();
                System.out.println("prevIndex "+ prevIndex);
                result[prevIndex] = i - prevIndex;
            }

            days.push(i);
        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    public static void main(String[] args) {
        int [] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures(temperatures);

    }
}
