import java.lang.reflect.Array;
import java.util.Arrays;

public class SecondLargest {
    static void main() {
        int[] arr = {5,4,6,3,7,2,8};

        Arrays.sort(arr);
        System.out.print("Secound Largest element of array : "+arr[arr.length-2]);
    }
}
