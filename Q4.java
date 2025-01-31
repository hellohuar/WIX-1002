/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q4;
import java.util.Random;
/**
 *
 * @author Albert Robert
 */
public class Q4 {
    public static int[][] initializeSeatingPlan(int rows,int cols){
        Random r = new Random();
        int[][]seatingPlan= new int[rows][cols];
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                seatingPlan[i][j] = r.nextInt(2);
            }
        }
        return seatingPlan;
    }
    public static void analyzeSeating(int[][]seatingPlan){
        int totalOccupied=0;
        int maxOccupiedRow=0;
        int maxOccupiedSeats=0;
        for (int i=0;i<seatingPlan.length;i++){
            int occupiedSeatsinRow=0;
            for(int j=0;j<seatingPlan[i].length;j++){
                if(seatingPlan[i][j]==1){
                    totalOccupied++;
                    occupiedSeatsinRow++;
                }    
            }
            if(occupiedSeatsinRow>maxOccupiedSeats){
                maxOccupiedSeats=occupiedSeatsinRow;
                maxOccupiedRow=i;
            }    
        }
        System.out.println("Total occupied seats: "+totalOccupied);
        System.out.println("Row with most occupied seats: Row "+(maxOccupiedRow+1));
        System.out.println("Seating plan: ");
        for(int[]row:seatingPlan){
            for(int seat:row){
                System.out.print(seat+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int rows=5;
        int cols=5;
        int[][]seatingPlan=initializeSeatingPlan(rows,cols);
        analyzeSeating(seatingPlan);
    }
}
