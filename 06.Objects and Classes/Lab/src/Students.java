import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {
    private String firstName;
    private String lastName;
    private int age;
    private String hometown;

    public String getHometown() {
        return this.hometown;
    }

    public void printInfo(){
        System.out.printf("%s %s is %d years old%n", this.firstName, this.lastName, this.age);
    }


    public Students(String firstName, String lastName, int age, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        List<Students> studentsList = new ArrayList<Students>();

        while(!command.equals("end")){
            String[] studentData = command.split(" ");
            Students s = new Students(studentData[0], studentData[1], Integer.parseInt(studentData[2]), studentData[3]);
            studentsList.add(s);

            command = input.nextLine();
        }

        String cityToSearch = input.nextLine();

        for(Students s : studentsList){
            if(s.getHometown().equals(cityToSearch)){
                s.printInfo();
            }
        }
    }
}
