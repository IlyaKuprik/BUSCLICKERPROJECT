package com.example.clicker;
/**
 * Created by Пользователь on 17.12.2016.
 */
public class Clicker {

    private int counter;
    private int numberOfClicks;


    void click(int value){
        counter+=value;
        numberOfClicks++;
    }

    void clean(){
        counter=0;
        numberOfClicks=0;

    }

    int getCounter(){
        return counter;
    }

    int getNumberOfClicks(){
        return numberOfClicks;
    }

    void setCounter(int value){
        counter=value;
    }

    void setNumberOfClicks(int value){
        numberOfClicks=value;
    }


}
