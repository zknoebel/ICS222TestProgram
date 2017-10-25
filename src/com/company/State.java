package com.company;

import java.util.LinkedList;
import java.util.ListIterator;

public class State {
    int id = 0;

    LinkedList<Integer> list0;
    LinkedList<Integer> list1;

    ListIterator<Integer> iter0;
    ListIterator<Integer> iter1;

    public State(LinkedList<Integer> list0, LinkedList<Integer> list1) {
        this.list0 = list0;
        this.list1 = list1;

        iter0 = list0.listIterator(0);
        iter1 = list1.listIterator(0);
    }

    public boolean act() {
        switch (id) {
            case 0:

                return act0();
            case 1:

                return act0();
            case 2:

                return act0();
            case 3:

                return act0();

                default:
                    return true;
        }
    }

    public boolean act0() {
        if(iter0.next() == null && iter1.next() == null) {
            iter0.previous();

            iter1.previous();
            iter1.previous();

            id = 1;

            return false;
        }
        else if (iter0.next() != null && iter1.next() == null) {
            iter0.previous();
            iter1.set(iter0.next());

            return false;
        }


        return true;
    }

    public boolean act1() {
        if(iter0.next() == null && iter1.next() == null) {
            iter0.previous();
            iter0.previous();

            id = 2;

            return false;
        }
        else if (iter0.next() == null && iter1.next() != null) {
            iter0.previous();

            iter1.previous();
            iter1.previous();

            return false;
        }


        return true;
    }
    public boolean act2() {
        if(iter0.next() == null && iter1.next() == null) {
            iter0.previous();

            iter1.previous();

            id = 3;

            return false;
        }
        else if (iter0.next() != null && iter1.next() != null) {
            iter0.previous();
            iter0.previous();

            iter1.set(null);

            return false;
        }


        return true;
    }
    public boolean act3() {
        return true;
    }
}
