import java.util.HashMap;
import java.util.Map;

public class IteratorMapExample {
    static void main() {
        Map<String,String> hashmap = new HashMap<>();
        hashmap.put("Bibek","Baram");
        hashmap.put("Deepak","Thapa");
        hashmap.put("Bindu","Baram");

        for (Map.Entry<String,String> i : hashmap.entrySet()){
            System.out.println("Firstname : "+i.getKey()+" "+"Lastname : "+i.getValue());
        }

        for (String fn : hashmap.keySet()){
            System.out.println("First Name : "+fn);
        }
        for (String ln : hashmap.values()){
            System.out.println("Last Name : "+ln);
        }
    }
}
