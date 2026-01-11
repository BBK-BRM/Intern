public class MergeArray {
    static void main() {
        int[] arr1 = {5,2,8,6,1};
        int[] arr2 = {5,4,6,3,7,2,8};

        int a = arr1.length;
        int b = arr2.length;
        int c = a+b;

        int[] mergeArray = new int[c];

        for (int i = 0; i < a;i++){
            mergeArray[i] = arr1[i];
        }
        for (int i = 0; i < b;i++){
            mergeArray[a+i] = arr2[i];
        }

        System.out.print("Array1 : ");
        for (int i = 0; i < a;i++) {
            System.out.print(arr1[i]+"\t");
        }
        System.out.println();

        System.out.print("Array2 : ");
        for (int i = 0; i < b;i++) {
            System.out.print(arr2[i]+"\t");
        }
        System.out.println();

        System.out.print("Merged Array : ");
        for (int i = 0; i < c;i++) {
            System.out.print(mergeArray[i]+"\t");
        }
    }
}
