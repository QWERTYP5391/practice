package ood;

public class Employee {

    private boolean isAvailable;
    private EmployeeType employeeType;

    Employee(boolean isAvailable, EmployeeType employeeType){
        this.isAvailable = isAvailable;
        this.employeeType = employeeType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }






}
