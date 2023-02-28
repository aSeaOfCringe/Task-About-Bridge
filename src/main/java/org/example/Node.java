package org.example;

public class Node {
    State state;
    Node next1, next2, next3;
    boolean a, b, c;

    public Node(int speedA, int speedB, int speedC, boolean a, boolean b, boolean c, int flame,
                Node next1, Node next2, Node next3){
        this.state = new State(speedA, speedB, speedC, a, b, c, flame);
        this.next1 = next1;
        this.next2 = next2;
        this.next3 = next3;

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void printNode(){
        if(state!=null)
        state.printState();
        else System.out.println("The end");
    }

    public int getFlame(){
        return this.state.getFlame();
    }

    public void setFlame(int flame){
        this.state.setFlame(flame);
    }

    public boolean getA(){
        return this.a;
    }
    public boolean getB(){
        return this.b;
    }
    public boolean getC(){
        return this.c;
    }

    public void setNext1(Node node){
        this.next1 = node;
    }
    public void setNext2(Node node){
        this.next2 = node;
    }
    public void setNext3(Node node){
        this.next3 = node;
    }

    public Node getNext1(){
        return this.next1;
    }
    public Node getNext2(){
        return this.next2;
    }
    public Node getNext3(){
        return this.next3;
    }

    public void setDeadEnd(boolean b){
        state.setDeadEnd(b);
    }

    public void setTarget(boolean b){
        state.setTarget(b);
    }
}
