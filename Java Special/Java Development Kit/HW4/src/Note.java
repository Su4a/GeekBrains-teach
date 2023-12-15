import java.util.ArrayList;

public class Note {
    private final ArrayList<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployeesFoExperience(String experience) {
        ArrayList<Employee> employeesExperience = new ArrayList<>();
        for (Employee e: employees) {
            if (e.getExperience().equals(experience)) employeesExperience.add(e);
        }
        return employeesExperience;
    }

    public ArrayList<String> getTelephoneNumberFoName(String name) {
        ArrayList<String> employeesTelephoneNumber = new ArrayList<>();
        for (Employee e: employees) {
            if (e.getName().equals(name)) employeesTelephoneNumber.add(e.getTelephoneNumber());
        }
        return employeesTelephoneNumber;
    }

    public Employee getEmployeesFoPersonnelNumber(String personnelNumber) {
        for (Employee e: employees) {
            if (e.getPersonnelNumber().equals(personnelNumber)) return e;
        }
        return null;
    }
}
