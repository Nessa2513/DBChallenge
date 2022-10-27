import org.testng.annotations.Test;
import utils.crud.EmployeeCrud;

import java.sql.Date;

public class TestEmployee {
    EmployeeCrud employeeCrud = new EmployeeCrud();

    @Test
    public void getAllEmployees(){
        employeeCrud.getAllEmployees();
    }

    @Test
    public void getEmployeesByLastName(){
        String lastName = "Ramirez";
        employeeCrud.getEmployeeByLastName(lastName);
    }

    @Test
    public void getEmployeeById(){
        int id = 74;
        employeeCrud.getEmployeeById(id);
    }

    @Test
    public void insertNewEmployee(){
        int idEmployee = 84;
        String firstName = "Carolina";
        String lastName = "Ramirez";
        String email = "caro@gmail.com";
        String phoneNumber = "594834";
        String address = "Cll 9 #14-78";
        double salary = 15455;
        Date birthDate = Date.valueOf("1988-04-05");
        int idCompany = 2;

        employeeCrud.insertNewEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary,birthDate,idCompany);
        employeeCrud.getEmployeeById(idEmployee);
    }

    @Test
    public void updateEmployee(){

        int idEmployee = 64;
        String firstName = "Camila";
        String lastName = "Panader";
        String email = "camis@gmail.com";
        String phoneNumber = "1518964";
        String address = "87 Rose av ";
        int salary = 8745;
        Date birthDate = Date.valueOf("1964-07-03");
        int idCompany = 4;

        employeeCrud.getEmployeeById(idEmployee);
        employeeCrud.updateEmployee(idEmployee,firstName,lastName,email,phoneNumber,address,salary, birthDate, idCompany);
        employeeCrud.getEmployeeById(idEmployee);
    }

    @Test
    public void deleteEmployee(){
        int idEmployee = 84;

        employeeCrud.getEmployeeById(idEmployee);
        employeeCrud.deleteEmployee(idEmployee);
        employeeCrud.getEmployeeById(idEmployee);
    }
}
