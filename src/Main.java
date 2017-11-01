import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list0 = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();

        boolean halted = false;

        int steps = 0;

        for( int i = 0; i < 49; i ++) {
            list0.add(0);
            list0.add(1);
        }
        list0.add(0);

        System.out.println("Input" + list0);
        System.out.println();

        State state = new State(list0, list1);

        while (!halted) {

            System.out.println("Step: " + steps);
            System.out.println();

            halted = state.act();
            steps ++;
        }

        System.out.println();

    }

}
