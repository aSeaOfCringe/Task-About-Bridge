package org.example;

public class Person {
    char person;
    int speed;

    public Person(char person, int speed){
        this.person = person;
        this.speed = speed;
    }

    public char getPerson(){
        return this.person;
    }

    public int getSpeed(){
        return this.speed;
    }
}
