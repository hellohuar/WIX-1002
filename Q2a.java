/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q2a;

/**
 *
 * @author Albert Robert
 */
class Book{
    private String title;
    private String author;
    private int yearPublished;
    public Book(String title,String author,int yearPublished){
        this.title=title;
        this.author=author;
        this.yearPublished=yearPublished;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return yearPublished;
    }
}
public class Q2a {

    public static void main(String[] args) {
        Book myBook= new Book("To Kill a Mockingbird","Harper Lee",1960);
        System.out.println("The book title is "+myBook.getTitle()+".");
        System.out.println("The author is "+myBook.getAuthor()+".");
        System.out.println("The year published is "+myBook.getYear()+".");
    }
}
