public class Employee {
    int id;
    String name;
    String post;
    int monthlySalary;

    int calculateAnnualSalary(int monthlySalary){
        return monthlySalary * 12;
    }
}
