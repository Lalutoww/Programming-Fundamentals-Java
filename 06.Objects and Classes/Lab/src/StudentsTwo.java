import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsTwo {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public StudentsTwo(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        List<StudentsTwo> studentsList = new ArrayList<>();

        while (!command.equals("end")) {
            String[] studentData = command.split(" ");
            if (isStudentExisting(studentsList, studentData[0], studentData[1])) {
                StudentsTwo s = getStudent(studentsList, studentData[0], studentData[1]);

                s.setAge(Integer.parseInt(studentData[2]));
                s.setHometown(studentData[3]);
            } else {
                StudentsTwo s = new StudentsTwo(studentData[0], studentData[1], Integer.parseInt(studentData[2]), studentData[3]);
                studentsList.add(s);
            }

            command = input.nextLine();
        }

        String cityToSearch = input.nextLine();

        for (StudentsTwo s : studentsList) {
            if (s.getHometown().equals(cityToSearch)) {
                s.printInfo();
            }
        }
    }

    private static StudentsTwo getStudent(List<StudentsTwo> studentsInfo, String firstName, String lastName) {
        for (StudentsTwo student : studentsInfo) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public static boolean isStudentExisting(List<StudentsTwo> studentsList, String firstName, String lastName) {
        for (StudentsTwo s : studentsList) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public String getHometown() {
        return this.hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void printInfo() {
        System.out.printf("%s %s is %d years old%n", this.firstName, this.lastName, this.age);
    }
}

