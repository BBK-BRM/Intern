public class Employee extends Person {
//    static String post;
    String post;


    static void main() {
    Person p1 = new Person();
    p1.name = "Bibek";
    p1.age = 23;
    p1.salary = 0;

    Employee e1 = new Employee();
    e1.post = "intern";
//        post  = "intern"

     Person p2 = new Person("deepak",24,18000);

     System.out.println("name : " + p1.name +"\n"+
                        "age  : "+p1.age+"\n"+
                        "salary : " + p1.salary +"\n"+
                        "post : " + e1.post +"\n"
     );

     System.out.println("name : " + p2.name +"\n"+
                "age  : "+p2.age+"\n"+
                "salary : " + p2.salary +"\n"
     );
    }
}
