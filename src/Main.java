import students.Student;
import students.StudentDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                Student s = new Student();
//                System.out.print("Roll: "); s.setRoll(sc.nextInt());
                sc.nextLine();
                System.out.print("Name: "); s.setName(sc.nextLine());
                System.out.print("City: "); s.setCity(sc.nextLine());
                System.out.print("Dept No(10,20,30, or 40): "); s.setDeptNo(sc.nextInt());
                dao.addStudent(s);
            } else if (ch == 2) {
                for (Student s : dao.getAllStudents()) {
                    System.out.println(s.getRoll() + " " + s.getName() + " " + s.getCity() + " " + s.getDeptNo());
                }
            } else if (ch == 3) {
                Student s = new Student();
                System.out.print("Enter roll no to update: "); s.setRoll(sc.nextInt());
                sc.nextLine();
                System.out.print("New Name: "); s.setName(sc.nextLine());
                System.out.print("New City: "); s.setCity(sc.nextLine());
                System.out.print("New Dept No: "); s.setDeptNo(sc.nextInt());
                dao.updateStudent(s);
            } else if (ch == 4) {
                System.out.print("Enter roll to delete: ");
                dao.deleteStudent(sc.nextInt());
            } else if (ch == 5) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
