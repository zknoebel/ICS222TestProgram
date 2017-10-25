import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class State {
    int id = 0;

    LinkedList<Integer> list0;
    LinkedList<Integer> list1;

    ListIterator<Integer> iter0;
    ListIterator<Integer> iter1;

    public State(LinkedList<Integer> list0, LinkedList<Integer> list1) {
        this.list0 = list0;
        this.list0.add(null);
        this.list0.addFirst(null);

        this.list1 = list1;
        this.list1.add(null);
        this.list1.addFirst(null);

        iter0 = this.list0.listIterator(1);
        iter1 = this.list1.listIterator(1);
    }

    private String underliner(List<Integer> list, int index) {
        String string = "[";

        for (int i = 0; i < list.size(); i++) {
            string += " ";

            String atIndex;

            if (list.get(i) == null) {
                atIndex = "□";
            }
            else {
                atIndex = list.get(i).toString();
            }

            if (i == index) {
                string += "\033[4m" + atIndex + "\033[0m";
            } else {
                string += atIndex;
            }

            if (i < list.size() - 1) {
                string += " ,";
            }
        }

        string += "]";
        return string;
    }

    public boolean act() {

        if (!iter0.hasNext()) {
            iter0.add(null);
            iter0.previous();
        }
        if (!iter1.hasNext()) {
            iter1.add(null);
            iter1.previous();
        }

        if (!iter0.hasPrevious()) {
            iter0.add(null);
        }
        if (!iter1.hasPrevious()) {
            iter1.add(null);
        }

        System.out.println("{");
        System.out.println("List 0: " + underliner(list0, iter0.nextIndex()));
        System.out.println("List 1: " + underliner(list1, iter1.nextIndex()));
        System.out.println("State: " + id);
        System.out.println("}");
        System.out.println();

        switch (id) {
            case 0:

                return act0();
            case 1:

                return act1();
            case 2:

                return act2();
            case 3:

                return act3();

            default:
                return true;
        }
    }

    public boolean act0() {
        boolean returnValue = false;
        Integer int0 = iter0.next();
        Integer int1 = iter1.next();

        if (int0 == null && int1 == null) {
            iter0.previous();

            iter1.previous();
            iter1.previous();

            id = 1;
        } else if (int0 != null && int1 == null) {
            iter0.previous();
            iter1.set(iter0.next());
        } else {
            returnValue = true;
        }

        return returnValue;
    }

    public boolean act1() {
        boolean returnValue = false;
        Integer int0 = iter0.next();
        Integer int1 = iter1.next();

        if (int0 == null && int1 == null) {
            iter0.previous();
            iter0.previous();

            id = 2;
        } else if (int0 == null && int1 != null) {
            iter0.previous();

            iter1.previous();
            iter1.previous();
        } else {
            returnValue = true;
        }

        return returnValue;
    }

    public boolean act2() {
        boolean returnValue = false;
        Integer int0 = iter0.next();
        Integer int1 = iter1.next();

        if (int0 == null && int1 == null) {
            iter0.previous();

            iter1.previous();

            id = 3;
        } else if (int0 != null && int1 != null) {
            iter0.previous();
            iter0.previous();

            iter1.set(null);
        } else {
            returnValue = true;
        }

        return returnValue;
    }

    public boolean act3() {
        return true;
    }

}
