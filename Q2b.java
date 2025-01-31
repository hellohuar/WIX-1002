/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q2b;
import java.util.Scanner;
/**
 *
 * @author Albert Robert
 */
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class Q2b {
    public static void checkAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Age is less than 18. Access deinied.");
        }
        else{
            System.out.println("Age is valid. Access granted.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age=scanner.nextInt();
        try{
            checkAge(age);
        }
        catch(InvalidAgeException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
