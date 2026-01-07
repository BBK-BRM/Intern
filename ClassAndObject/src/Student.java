public class Student {
    int id;
    String name;
    float marks;

    void calculateGrade(float marks){
        if (marks >= 80){
            System.out.println("Grade : A");
        } else if (marks >= 60 ) {
            System.out.println("Grade : B");
        } else if (marks >= 40) {
            System.out.println("Grade : c");
        }else {
            System.out.println("Grade : Fail");
        }
    }

    static void main() {
        Student s = new Student();
        s.id = 1;
        s.name = "Bibek Baram";
        s.marks = 80;

        s.calculateGrade(s.marks);
    }
}
