import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();

        boolean halted = false;

        int steps = 0;

        list0.add(0);
        list0.add(1);
        list0.add(0);
        list0.add(1);

        State state = new State(list0, list1);

        while (!halted) {

            halted = state.act();
            steps ++;
        }

        System.out.println();
        System.out.println("Steps: " + steps);

    }

}
