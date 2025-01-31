/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.report;
import java.io.*;
import java.util.*;
/**
 *
 * @author Albert Robert
 */
class OAIRecord{
    String doi;
    String title;
    String subject;
    String[]authors=new String[8];
    String keyword;
    String status;
    public OAIRecord(String doi,String title,String subject,String[]authors,String keyword,String status){
        this.doi=doi;
        this.title=title;
        this.subject=subject;
        this.authors=authors;
        this.keyword=keyword;
        this.status=status;
        
    }
}
public class Report {

    public static void main(String[] args) {
        String inputFile = "oaiset.csv";
        OAIRecord[]data=new OAIRecord[50];
        System.out.println("Loading Dataset...");
        loadRecord(inputFile,data);
        System.out.println("The curated record is as follow: ");
        printRecord(cleanRecord(data));
        System.out.println("\nThe summary report is as follow: ");
        reportData(cleanRecord(data));
    }
    public static void loadRecord(String inputFile,OAIRecord[]data){
        try(BufferedReader reader =new BufferedReader(new FileReader(inputFile))){
            String line;
            int index=0;
            while((line=reader.readLine())!=null&&index<50){
                String[]parts=line.split(";",-1);
                String[]authors=Arrays.copyOfRange(parts, 3, 11);
                data[index++]=new OAIRecord(parts[0],parts[1],parts[2],authors,parts[11],parts[12]);
                
            }
        }
        catch(IOException e){
            System.out.println("Error reading this file "+e.getMessage());
        }
    }
    public static OAIRecord[] cleanRecord(OAIRecord[]data){
        ArrayList<OAIRecord> curatedList=new ArrayList<>();
        for(OAIRecord record : data){
            if(record!=null&&!record.status.equalsIgnoreCase("deleted")){
                curatedList.add(record);
            }
        }
        return curatedList.toArray(new OAIRecord[0]);
    }
    public static void printRecord(OAIRecord[]data){
        int recordCount=1;
        for(OAIRecord record:data){
            System.out.print("Record "+recordCount++ +" ");
            System.out.print(record.doi+"\""+record.title+"\""+record.subject+"{");
            
            for(int i=0;i<record.authors.length;i++){
                if(record.authors[i]!=null&&!record.authors[i].isEmpty()){
                    if(i>0){
                        System.out.print(", ");
                        System.out.print(record.authors[i]);
                    }
                }
            }
            System.out.print("} ");
            System.out.println(record.keyword+" "+record.status);
        }
    }
    public static void reportData(OAIRecord[]data){
        TreeMap<String,Integer> authorPublicationCount = new TreeMap<>();
        for(OAIRecord record:data){
            for(String author : record.authors){
                if(author!=null&&!author.isEmpty()){
                    authorPublicationCount.put(author, authorPublicationCount.getOrDefault(author,0)+1);
                }
            }
        }
        for(Map.Entry<String,Integer> entry : authorPublicationCount.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
