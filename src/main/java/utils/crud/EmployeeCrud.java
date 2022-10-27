package utils.crud;

import entities.Employee;
import queries.EmployeeQuery;

import java.sql.Date;
import java.util.List;

public class EmployeeCrud {

    EmployeeQuery employeeQuery = new EmployeeQuery();
    List<Employee> employeesList;
    Employee employee;

    //Execute queries and print the results

    public void getAllEmployees(){
        employeesList = employeeQuery.getAllEmployees();

        if(employeesList.size() != 0){
            for (Employee e:
                    employeesList) {
                printEmployeesInfo(e);
                System.out.println("");
            }
        }else{
            System.out.println("No employees were found");
        }
    }

    public void getEmployeeById(int idEmployee){
        employee = employeeQuery.getEmployeeById(idEmployee);

        if(employee != null){
            printEmployeesInfo(employee);
        }else {
            System.out.println("The employee with id '" + idEmployee + "' wasn't found");
        }
    }

    public void getEmployeeByLastName(String lastName){
        employeesList = employeeQuery.getEmployeeByLastName(lastName);

        if(employeesList.size() != 0){
            for (Employee em:
                    employeesList) {
                printEmployeesInfo(em);
                System.out.println("");
            }
        }else {
            System.out.println("The employee with last name '" + lastName + "' wasn't found");
        }
    }

    public void insertNewEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address, double salary, java.util.Date birthDate, int idCompany){

        employee = new Employee();
        employee.setIdEmployee(idEmployee);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setBirthDate(birthDate);
        employee.setIdCompany(idCompany);

        int employeeId = employeeQuery.insertEmployee(employee);

        if(employeeId != -1){
            System.out.println("A new employee with id " + idEmployee + " was created");
        }else {
            System.out.println("No employee was created");
        }
    }

    public void updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address, double salary, Date birthDate, int idCompany){

        int employeeId = employeeQuery.updateNewEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,idCompany);

        if(employeeId != -1){
            System.out.println("The employee with id " + idEmployee + " was updated");
        }else {
            System.out.println("No employee was updated");
        }

    }
    public void deleteEmployee(int idEmployee){

        int employeeId = employeeQuery.deleteEmployee(idEmployee);

        if(employeeId != -1){
            System.out.println("The employee with id " + idEmployee + " was deleted");
        }else {
            System.out.println("No employee was deleted");
        }

    }

    // Print the Employee information
    private void printEmployeesInfo(Employee employee) {
        System.out.println("Employee Id: "+ employee.getIdEmployee());
        System.out.println("Employee first name: " + employee.getFirstName());
        System.out.println("Employee last name: " + employee.getLastName());
        System.out.println("Employee email: " + employee.getEmail());
        System.out.println("Employee phone: " + employee.getPhoneNumber());
        System.out.println("Employee address: " + employee.getAddress());
        System.out.println("Employee Salary: " + employee.getSalary());
        System.out.println("Employee birth date: " + employee.getBirthDate());
        System.out.println("Employee id Company: " + employee.getIdCompany());
    }

}
