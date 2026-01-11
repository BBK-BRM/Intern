public class Employee {
    int empID;
    String name;
    int age;
    String post;

    public Employee(int empID, String name,int age,String post){
        this.empID  = empID;
        this.name = name;
        this.age = age;
        this.post = post;
    }

    @Override
    public String toString(){
        return " ---------------------" +
                "\n Employee ID: " + empID +
                "\n Name: " + name +
                "\n Age: " + age +
                "\n post: " + post+
                "\n---------------------";
    }
}
