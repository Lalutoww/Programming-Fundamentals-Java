import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompanyRoster {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Employee> employeeList = new ArrayList<>();
        List<String> departmentNamesList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> commands = new ArrayList<>(Arrays.stream(input.nextLine().split(" ")).toList());

            String name = commands.get(0);
            double salary = Double.parseDouble(commands.get(1));
            String position = commands.get(2);
            String department = commands.get(3);

            Employee employee = new Employee(name, salary, position, department);

            if (commands.size() == 5 && isInteger(commands.get(4))) {
                int age = Integer.parseInt(commands.get(4));
                employee.setAge(age);
            } else if (commands.size() == 5 && !isInteger(commands.get(4))) {
                String email = commands.get(4);
                employee.setEmail(email);
            } else if (commands.size() > 5) {
                String email = commands.get(4);
                int age = Integer.parseInt(commands.get(5));
                employee.setAge(age);
                employee.setEmail(email);
            }

            if (!departmentNamesList.contains(department)) {
                departmentNamesList.add(department);
            }
            employeeList.add(employee);
        }

        for (int i = 0; i < departmentNamesList.size(); i++) {
            int currentDepartment = i;
            List<Employee> allDepartmentEmployees = employeeList.stream().filter(e -> e.getDepartment().equals(departmentNamesList.get(currentDepartment))).toList();
            Department department = new Department(allDepartmentEmployees);

            departmentList.add(department);
        }
        departmentList = departmentList.stream().sorted((d1, d2) -> Double.compare(d2.calculateAverageSalary(), d1.calculateAverageSalary())).toList();
        Department bestDepartment = departmentList.getFirst();

        System.out.println("Highest Average Salary: " + bestDepartment.getName());
        bestDepartment.printDepartment();
    }

    public static boolean isInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Null or empty strings are not integers
        }

        int startIndex = 0;
        if (input.charAt(0) == '-') {
            // If the first character is '-', check if it has digits after it
            if (input.length() == 1) {
                return false; // "-" is not a valid integer
            }
            startIndex = 1; // Skip the '-' sign
        }

        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false; // Return false if a non-digit character is found
            }
        }

        return true; // All characters are digits or valid '-' sign
    }

    static class Employee {
        String name;
        Double salary;
        String position;
        String department;
        String email;
        int age;

        Employee(String name, Double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        public Double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }

        void printEmployee() {
            System.out.printf("%s %.2f %s %d%n", name, salary, email, age);
        }
    }

    static class Department {
        List<Employee> employees;
        String departmentName;
        double averageSalary;

        Department(List<Employee> employees) {
            this.employees = employees;
            this.departmentName = employees.getFirst().getDepartment();
        }

        public String getName() {
            return departmentName;
        }

        Double calculateAverageSalary() {
            double totalSalary = this.employees.stream().mapToDouble(Employee::getSalary).sum();
            this.averageSalary = totalSalary / this.employees.size();
            return averageSalary;
        }

        void printDepartment() {
            employees = employees.stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).toList();
            for (Employee employee : employees) {
                employee.printEmployee();
            }
        }
    }

}
