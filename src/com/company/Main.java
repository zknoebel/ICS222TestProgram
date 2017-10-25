package com.company;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();

        State state = new State(list0, list1);

        boolean halted = false;

        list0.add(0);
        list0.add(0);


        while (!halted) {

            halted = state.act();
        }

        System.out.println("String 0: " + list0);
        System.out.println("String 1: " + list1);

    }
}
