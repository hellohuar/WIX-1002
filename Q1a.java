/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q1a;
import java.util.Scanner;
/**
 *
 * @author Albert Robert
 */
public class Q1a {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int positive=0;
        int negative=0;
        int zero=0;
        System.out.print("Enter numbers (press X to quit): ");
        while(true){
            String input=scanner.nextLine();
            if(input.equalsIgnoreCase("X")){
                break;
            }
            try{
                int number=Integer.parseInt(input);
                if(number>0){
                    positive++;
                }
                else if(number<0){
                    negative++;
                }
                else if(number==0){
                    zero++;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number or 'X' to quit.");
            }
            System.out.print("Enter numbers (press X to quit): ");
        }
        System.out.println("The number of positive number is: "+positive);
        System.out.println("The number of negative number is: "+negative);
        System.out.println("The number of zeroes is: "+zero);
    }
}
