package org.example;

public class State {
    private Person personA, personB, personC, empty;
    private Person[] p1 = new Person[3];
    private Person[] p2 = new Person[3];

    private int flame;
    private boolean deadEnd, target;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public State(int speedA, int speedB, int speedC, boolean a, boolean b, boolean c, int flame){
        this.personA = new Person('A', speedA);
        this.personB = new Person('B', speedB);
        this.personC = new Person('C', speedC);
        this.empty = new Person(' ', 0);

        if (a==true) {
            setP1(personA, 0);
            setP2(empty, 0);
        }
        else {
            setP1(empty, 0);
            setP2(personA, 0);
        }
        if (b==true) {
            setP1(personB, 1);
            setP2(empty, 1);
        }
        else {
            setP1(empty, 1);
            setP2(personB, 1);
        }
        if (c==true) {
            setP1(personC, 2);
            setP2(empty, 2);
        }
        else {
            setP1(empty, 2);
            setP2(personC, 2);
        }

        this.flame = flame;
        this.deadEnd = false;
        this.target = false;
    }

    public void setP1(Person person, int i){
        this.p1[i] = person;
    }

    public void setP2(Person person, int i){
        this.p2[i] = person;
    }

    public void setFlame(int flame){
        this.flame = flame;
    }

    public int getFlame(){
        return this.flame;
    }

    public void setDeadEnd(boolean b){
        this.deadEnd = b;
    }

    public void setTarget(boolean b){
        this.target = b;
    }

    public void printState(){
        if (this.deadEnd) System.out.print(ANSI_RED);
        if (this.target) System.out.print(ANSI_GREEN);

        System.out.print("P1: ");
        for (int i=0; i<3; i++){
            System.out.print(p1[i].getPerson() + " ");
        }
        System.out.print(", Flame left = " + flame);
        System.out.print(", P2: ");
        for (int i=0; i<3; i++){
            System.out.print(p2[i].getPerson() + " ");
        }
        System.out.print(ANSI_RESET);
    }
}
