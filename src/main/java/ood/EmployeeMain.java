package ood;

public class EmployeeMain {

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee(false, EmployeeType.RESPONDANT);
        employees[0] = new Employee(false, EmployeeType.MANAGER);
        employees[0] = new Employee(false, EmployeeType.DIRECTOR);
        dispatchCall(employees);
    }

    public static void dispatchCall(Employee[] employees){

        for(int i = 0; i < employees.length; i++){
            Employee currentEmployee = employees[i];
            if(currentEmployee.isAvailable()){
                currentEmployee.setAvailable(false);
                break;
            }
        }

    }
}
