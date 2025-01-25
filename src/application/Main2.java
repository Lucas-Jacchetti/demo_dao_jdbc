package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelDao.DaoFactory;
import modelDao.DepartmentDao;
import modelDao.SellerDao;
import modelEntities.Department;
import modelEntities.Seller;

@SuppressWarnings("unused")
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Department> list = new ArrayList<>();

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("TESTE 1: DepartmentDaoJDBC insert -----");
        Department newDepartment = new Department(30, "x");
        departmentDao.insert(newDepartment);
        System.out.println("Inserido, Novo ID = " + newDepartment.getID());

        System.out.println();
        System.out.println();

        System.out.println("TESTE 2: DepartmentDaoJDBC findByID -----");
        Department department = departmentDao.findByID(1);
        System.out.println(department);

        System.out.println();
        System.out.println();

        System.out.println("TESTE 3: DepartmentDaoJDBC update -----");
        department = departmentDao.findByID(1);
        department.setName("Gaming");
        departmentDao.update(department);
        System.out.println("Update completo!");

        System.out.println();
        System.out.println();

        System.out.println("TESTE 4: DepartmentDaoJDBC deleteById -----");
        System.out.println("Insira o Id do departamento a ser deletado");
        int id = sc.nextInt();
        departmentDao.deleteByID(id);

        System.out.println();
        System.out.println();

        System.out.println("TESTE 4: DepartmentDaoJDBC findAll -----");
        list = departmentDao.findAll();
        for (Department obj : list) {
            System.out.println(obj);
        }

        
        
        sc.close();
    }
}
