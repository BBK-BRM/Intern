public class SwapTwoNumber {
    void swapTwoVariableUsingThird(int n1,int n2){
        System.out.println("Value to be swapped : "+n1+" "+n2);
        int n3 = n1;
        n1 = n2;
        n2 = n3;
        System.out.println("Swapped Value : "+ n1 +" "+n2);
    }
    void swapTwoNumber(int n1, int n2){
        System.out.println("Value to be swapped : "+n1+" "+n2);
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
        System.out.println("Swapped Value : "+ n1 +" "+n2);
    }
    void main(){
        swapTwoVariableUsingThird(2,3);
        swapTwoNumber(2,3);
    }
}