import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ArrayListHashmapExample {
    static void main() {
        ArrayList<String> name = new ArrayList<String>();
        name.add("Bibek");
        name.add("samir");
        name.add("Deepak");
        name.add("Bibek");

        System.out.println(name);

        HashSet<String> withoutDuplicates = new HashSet<String >(name);
        System.out.println(withoutDuplicates);

        Collections.sort(name);
        System.out.println(name);
    }
}
