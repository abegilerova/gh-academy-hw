package twoPointers;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        //Arrays.sort(people);

        //bucket sort and count sort
        int[] count = new int [30001];

       for (int x : people){
           count[x]++;
       }

        System.out.println(Arrays.toString(count));

       for (int i = 0, j = 0; i < people.length; i++){
           while(count[i] > 0){
               people[j] = i;
               count[i]--;
               j++;
           }
       }

       System.out.println(Arrays.toString(people));

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while(left<= right){
            int sum = people[left] + people[right];

            if(sum <= limit){
                boats++;
                left++;
                right--;
            } else {
                right--;
                boats++;
            }

        }

        //System.out.println(boats);

        return boats;

    }

    public static void main(String[] args) {
        int [] people = {2,2,3,4,5,2,1};
        int limit = 3;

        numRescueBoats(people,limit);



    }
}
