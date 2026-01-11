import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    static void main() {
        Map<Integer,Integer> m = new HashMap<>();

        m.put(1,2);
        m.put(2,4);
        m.put(3,8);
        m.put(4,1);

        int maxValue = Collections.max(m.values());

        for (Map.Entry<Integer,Integer> e : m.entrySet()){
            if (e.getValue() == maxValue){
                System.out.println("key : "+e.getKey()+"Value : "+e.getValue());
            }
        }
    }
}
