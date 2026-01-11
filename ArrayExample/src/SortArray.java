import java.util.Scanner;

public class SortArray {
    static void main() {
        int[] arr = {2,4,5,1,8};
        int temp ;

        System.out.print("Unsorted Array  : ");
        for (int a : arr){
            System.out.print(a+"\t");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[i] > arr[j] ) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]  = temp;
                }
            }
        }
        System.out.print("Sorted Array : ");
        for(int a : arr){
            System.out.print(a+"\t");
        }
    }
}
