package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner cardNumbers = new Scanner(System.in);
        System.out.print("Enter a Credit Card Number: ");
        long number = cardNumbers.nextLong();
        cardNumbers.close();

        String numberAsString = String.valueOf(number);
        int[] digits= new int[numberAsString.length()];

        for(int i= numberAsString.length()-1; i>-1; i--){
            int digit =numberAsString.charAt(i)-'0';
            digits[numberAsString.length()-1-i]=digit;

        }
        int productSum=0;
        int nonProductSum=0;
        for(int i=0; i<digits.length; i++) {
            if(i % 2 !=0) {
                int product = digits[i] * 2;
                int sum = 0;
                while (product != 0) {
                    sum = sum + product % 10;
                    product = product / 10;
                }
                productSum += sum;
            }else{
                nonProductSum +=digits[i];
            }
        }
        boolean isLegit=false;
        int finalSum=productSum+nonProductSum;
        if(finalSum % 10 == 0){
            isLegit = true;
        }
        if (isLegit){
            if ((numberAsString.length() == 15)
                &&  (numberAsString.startsWith("34") || numberAsString.startsWith("37"))) {
                System.out.println("AMEX");
            }else if ((numberAsString.length() == 16) && (numberAsString.startsWith("51")
            ||numberAsString.startsWith("52") || numberAsString.startsWith("53")
            ||numberAsString.startsWith("54") || numberAsString.startsWith("55"))) {
                System.out.println("MASTERCARD");
            }else if (((numberAsString.length() == 16) ||(numberAsString.startsWith("4")))) {
                System.out.println("VISA");
            } else {
                System.out.println("INVALID");
            }
        } else {
            System.out.println("INVALID");
        }
    }
}
