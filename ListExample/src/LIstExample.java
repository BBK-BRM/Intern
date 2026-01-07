import java.util.ArrayList;

public class LIstExample {
    static void main() {
        ArrayList list = new ArrayList();
        list.addFirst(new String("bibek"));
        System.out.println(list.getFirst());

        list.add(1,"Baram");
        System.out.println(list.getLast());
    }
}

