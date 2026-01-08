public class Manager extends Employee {
    static void main() {
        Manager m = new Manager();
        m.id = 1;
        m.name = "Bibek";
        m.post = "manager";
        m.monthlySalary = 50000;

        System.out.println("id : "+ m.id);
        System.out.println("name : "+ m.name);
        System.out.println("post : "+m.post);
        System.out.println("montly Salary :"+m.monthlySalary);

        System.out.println("Annual salary : "  + m.calculateAnnualSalary(m.monthlySalary));
    }
}
