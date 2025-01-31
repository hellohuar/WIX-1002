/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q2c;

/**
 *
 * @author Albert Robert
 */
interface Playable{
    void play();
}
class Guitar implements Playable{
    @Override
    public void play(){
        System.out.println("Playing the Guitar.");
    }
}
class Piano implements Playable{
    @Override
    public void play(){
        System.out.println("Playing the Piano.");
    }
}
public class Q2c {

    public static void main(String[] args) {
        Playable[] instruments=new Playable[2];
        instruments[0]=new Guitar();
        instruments[1]=new Piano();
        for(Playable instrument: instruments){
            instrument.play();
        }
    }
}
