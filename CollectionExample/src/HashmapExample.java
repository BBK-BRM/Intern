import java.util.HashMap;

public class HashmapExample {
    static void main() {
        String str = "my name is bibek baram";

        HashMap<String,Integer> hm = new HashMap<>();

        String[] strArr = str.split(" ");

        for (String a:strArr){
            if (hm.containsKey(a)){
                hm.put(a,hm.get(a)+1);
            }else{
                hm.put(a,1);
            }
        }

        System.out.println(hm);
    }
}
