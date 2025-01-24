package application;

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

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        
        System.out.println("TESTE 1: DepartmentDaoJDBC insert -----");
        Department newDepartment = new Department(21, "x");
        departmentDao.insert(newDepartment);
        System.out.println("Inserido, Novo ID = " + newDepartment.getID());

        System.out.println();
        System.out.println();

        System.out.println("TESTE 2: DepartmentDaoJDBC findByID -----");
        Department department = departmentDao.findByID(1);
        System.out.println(department);

        System.out.println();
        System.out.println();

        System.out.println("TESTE 2: DepartmentDaoJDBC update -----");
        department = departmentDao.findByID(15);
        department.setName("Gaming");
        departmentDao.update(department);
        System.out.println("Update completo!");

    }
}
