package application;

import java.util.Date;
import java.util.List;

import modelDao.DaoFactory;
import modelDao.SellerDao;
import modelEntities.Department;
import modelEntities.Seller;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
    
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Teste 1: seller findByID ====");

        Seller seller = sellerDao.findByID(3);
        System.out.println(seller);

        System.out.println("Teste 2: seller findByDepartment ====");

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
    }
}
