package org.example;

import java.util.Scanner;

public class Main {

    static void addNode(Node node, int speedA, int speedB, int speedC, boolean goingBack){
        if (node == null) return;
        if (node.getA()==false && node.getB()==false && node.getC()==false) {
            node.setTarget(true);
            return;
        }
        if (goingBack==false){
            int max = speedA > speedB ? speedA : speedB;
            if (node.getFlame()-max >= 0 && node.getA() && node.getB()){
                node.setNext1(new Node(speedA, speedB, speedC, false, false, node.getC(),
                        (node.getFlame()-max), null, null, null));
            }
            else if (node.getA() && node.getB()) node.setDeadEnd(true);

            max = speedA > speedC ? speedA : speedC;
            if (node.getFlame()-max >= 0 && node.getA() && node.getC()){
                node.setNext2(new Node(speedA, speedB, speedC, false, node.getB(), false,
                        (node.getFlame()-max), null, null, null));
            }
            else if (node.getA() && node.getC()) node.setDeadEnd(true);

            max = speedB > speedC ? speedB : speedC;
            if (node.getFlame()-max >= 0 && node.getB() && node.getC()){
                node.setNext3(new Node(speedA, speedB, speedC, node.getA(), false, false,
                        (node.getFlame()-max), null, null, null));
            }
            else if (node.getB() && node.getC()) node.setDeadEnd(true);

            if (node.getNext1()!=null) {
                addNode(node.next1, speedA, speedB, speedC, true);
            }
            if (node.getNext2()!=null) {
                addNode(node.next2, speedA, speedB, speedC, true);
            }
            if (node.getNext3()!=null) {
                addNode(node.next3, speedA, speedB, speedC, true);
            }
        }
        else {
            if (node.getFlame()-speedA >= 0 && node.getA() == false){
                node.setNext1(new Node(speedA, speedB, speedC, true, node.getB(), node.getC(),
                        (node.getFlame()-speedA), null, null, null));
            }
            else if (node.getA() == false) node.setDeadEnd(true);

            if (node.getFlame()-speedB >= 0 && node.getB() == false){
                node.setNext2(new Node(speedA, speedB, speedC, node.getA(), true, node.getC(),
                        (node.getFlame()-speedB), null, null, null));
            }
            else if (node.getB() == false) node.setDeadEnd(true);

            if (node.getFlame()-speedC >= 0 && !node.getC()){
                node.setNext3(new Node(speedA, speedB, speedC, node.getA(), node.getB(), true,
                        (node.getFlame()-speedC), null, null, null));
            }
            else if (node.getC() == false) node.setDeadEnd(true);

            if (node.getNext1()!=null) addNode(node.next1, speedA, speedB, speedC, false);

            if (node.getNext2()!=null) {
                addNode(node.next2, speedA, speedB, speedC, false);
            }
            if (node.getNext3()!=null) addNode(node.next3, speedA, speedB, speedC, false);
        }
    }

    static void printGraph(Node node, String space){
        if (node == null) return;
        if (node.next1 != null) printGraph(node.next1, space + "                                     ");
        if (node.next2 != null) printGraph(node.next2, space + "                                     ");
        System.out.print("\n" + space);
        node.printNode();
        //space = "  ";
        if (node.next3 != null) {
            printGraph(node.next3, space + "                                     ");
        }

    }

    public static void main(String[] args) {
        int speedA, speedB, speedC, flame;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease, enter speed for person A = ");
        speedA = sc.nextInt();
        System.out.print("\nPlease, enter speed for person B = ");
        speedB = sc.nextInt();
        System.out.print("\nPlease, enter speed for person C = ");
        speedC = sc.nextInt();
        System.out.print("\nPlease, enter flame duration flame = ");
        flame = sc.nextInt();
        Node node = new Node(speedA, speedB, speedC, true, true, true, flame, null, null, null);
        addNode(node, speedA, speedB, speedC, false);
        printGraph(node, "  ");
        System.out.println("\n");
    }
}