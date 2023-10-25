import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Supervisor().addAllSalaryEmployee(100);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Employee());
        employees.add(new Supervisor());

        for (Employee e: employees) {
            System.out.println(e.getSalary() + " - " + e.getDate());
        }
    }

}