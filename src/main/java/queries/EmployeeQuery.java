package queries;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.util.Date;
import java.util.List;

public class EmployeeQuery {
    private JpaManager jpaManager = new JpaManager();
    private EntityManager manager;
    private Employee employee;
    private List<Employee> listEmployee;
    private EntityTransaction transaction;

    public EmployeeQuery(){
        //Create new entity manager and transaction
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }
    public List<Employee> getAllEmployees() {

        //Get all employees using 'createQuery' operation
        listEmployee =  manager.createQuery("FROM employee").getResultList(); //Crea un Query que dice que se traiga todo de la tabla employee

        return listEmployee;
    }

    public Employee getEmployeeById(int id) {

        //Get employee by id using 'find' operation
        employee = manager.find(Employee.class,id);

        return employee;
    }

    public List<Employee> getEmployeeByLastName(String lastName) {

        //Get employees by lastname using 'createQuery' operation
        listEmployee = manager.createQuery("SELECT e FROM employee e WHERE e.lastName = :lastName").setParameter("lastName",lastName).getResultList();
// Los dos puntos antes del nombre :lastName es un parámetro y luego se le indica que tiene el parámetro
        return listEmployee; //Se retornan resultados como una lista
    }

    public int insertEmployee(Employee employee){

        //Begin transaction
        transaction.begin();
        //Create a new employee using 'persist' operation
        manager.persist(employee);

        try{
            //Commit transaction
            transaction.commit();
            return employee.getIdEmployee();

        }catch(Exception exception){
            //Rollback transaction
            transaction.rollback();
            System.out.println("Database wasn't updated");
            return -1;

        }


    }

    public int updateNewEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address, double salary, Date birthDate, int idCompany){

        employee = getEmployeeById(idEmployee);

        if(employee != null){
            //Update employees attributes
            employee.setIdEmployee(idEmployee);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setAddress(address);
            employee.setSalary(salary);
            employee.setBirthDate(birthDate);
            employee.setIdCompany(idCompany);

            //Begin transaction
            transaction.begin();
            //Update company using 'merge' operation
            manager.merge(employee);

            try{
                //Commit transaction
                transaction.commit();
                return employee.getIdEmployee();

            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
                return -1;
            }

        }else{
            System.out.println("Employee wasn't found");
            return -1;
        }

    }

    public int deleteEmployee(int idEmployee){

        employee = getEmployeeById(idEmployee);

        if(employee != null){

            //Begin transaction
            transaction.begin();
            //Delete company using 'remove' operation
            manager.remove(employee);

            try{
                //Commit transaction
                transaction.commit();
                return employee.getIdEmployee();

            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
                return -1;
            }

        }else{
            System.out.println("Employee wasn't found");
            return -1;
        }


    }
}
