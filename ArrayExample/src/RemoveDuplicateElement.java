import java.util.Arrays;

public class RemoveDuplicateElement {
    static void main() {
        int[] arr = {5,4,6,6,3,7,2,8};

        Arrays.sort(arr);
        int idx = 0;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                arr[idx++] =arr[i];
            }
        }

        for(int i = 0; i < idx; i++){
            System.out.print(arr[i]);
        }
    }
}
