import java.util.ArrayList;
import java.util.Iterator;

public class Services {
    ArrayList<Employee> employees = new ArrayList<>();

    int id =100;
    public void addEmployee(String name,int age,String post){
        employees.add(new Employee(++id,name,age,post));
        System.out.println("Employee Added Successfully.");
    }

    public Employee searchById(int id){
        for (Employee emp :employees){
            if (emp.empID == id){
                return emp;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, int age, String post){
        Employee emp = searchById(id);
        if (emp != null){
            emp.name = name;
            emp.post = post;
            emp.age = age;
            System.out.println("Update Successfully.");
        }else{
            System.out.println("Employee not found.");
        }
    }

    public void deleteEmployee(int id){
        Iterator<Employee> i = employees.iterator();
        while (i.hasNext()){
            if (i.next().empID == id){
                i.remove();
                System.out.println("Employee with id " +id+" deleted successfully.");
            }else {
                System.out.println("Employee not found.");
            }
        }
    }

    public void displayEmployee(){
        if (employees.isEmpty()){
            System.out.println("No Employee found.");
        }else {
            for (Employee emp : employees){
                System.out.println(emp);
            }
        }
    }


}
