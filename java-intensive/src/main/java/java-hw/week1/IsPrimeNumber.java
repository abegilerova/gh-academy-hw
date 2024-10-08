package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isPrime (int number){
        if (number <= 1){
            return false;
        }

        for(int i = 2; i <= number/2 ; i++){
            if(number % i != 0){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


        System.out.println(isPrime(6 ));

    }
}