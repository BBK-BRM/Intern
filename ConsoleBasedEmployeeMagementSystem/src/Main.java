import java.util.Scanner;

public class Main {
    static void main() {
        System.out.println("\t********************************");
        System.out.println("\t|\tEMPLOYEE MANAGEMENT SYSTEM  |");
        System.out.println("\t********************************");

        Services services = new Services();

        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Select the Option.");
                System.out.println("-----------------------------");
                System.out.println("1.Add New Employee.");
                System.out.println("2.Update Existing Employee.");
                System.out.println("3.Delete Employee.");
                System.out.println("4.Display All Employee.");
                System.out.println("5.Search Employee By ID.");
                System.out.println("6.Exit");
                System.out.print("Enter your Option  : ");
                int opt = sc.nextInt();

                switch (opt){
                    case 1:

                        Scanner sc1 = new Scanner(System.in);
                        System.out.print("Employee Name : ");
                        String name = sc1.nextLine();

                        Scanner sc2 = new Scanner(System.in);
                        System.out.print("Age : ");
                        int age = sc2.nextInt();

                        Scanner sc3 = new Scanner(System.in);
                        System.out.print("Post : ");
                        String post = sc3.nextLine();

                        services.addEmployee(name,age,post);
                        break;
                    case 2:
                        Scanner sc4 = new Scanner(System.in);
                        System.out.print("Enter Employee ID to update: ");
                        int id = sc4.nextInt();
                        Employee emp = services.searchById(id);
                        if (emp != null){
                            Scanner sc5 = new Scanner(System.in);
                            System.out.print("Enter New Name: ");
                            name = sc5.nextLine();

                            Scanner sc6 = new Scanner(System.in);
                            System.out.print("Enter New age: ");
                            age = sc6.nextInt();

                            Scanner sc7 = new Scanner(System.in);
                            System.out.print("Enter New post: ");
                            post = sc7.nextLine();

                            services.updateEmployee(id, name, age, post);
                        }else{
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 3:
                        Scanner sc8 = new Scanner(System.in);
                        System.out.print("Enter Employee ID to delete: ");
                        id = sc8.nextInt();

                        services.deleteEmployee(id);
                        break;
                    case 4:
                        services.displayEmployee();
                        break;
                    case 5:
                        Scanner sc9 = new Scanner(System.in);
                        System.out.print("Enter Employee ID to search: ");
                        id = sc9.nextInt();

                        emp = services.searchById(id);
                        if (emp != null){
                            System.out.println(emp);
                        }else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter Valid Option.");
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid Option | Invalid Entry.");
            }
        }while (true);
    }
}
