public class MinMaxElement {
    static void main() {
        int[] number = {5,2,8,6,1};

        int minElement = number[0];
        int maxElement = number[0];
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] > maxElement){
                maxElement = number[i];
            }
            if(number[i] < minElement){
                minElement = number[i];
            }
        }
        System.out.println("Max element : "+ maxElement);
        System.out.println("Min element : "+ minElement);
    }
}
