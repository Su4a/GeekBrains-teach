public class Supervisor extends Employee {

    public void addAllSalaryEmployee(int salary) {
        Employee.salaryAll += salary;
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
