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
        Department newDepartment = new Department(5, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserido, Novo ID = " + newDepartment.getID());


    }
}
