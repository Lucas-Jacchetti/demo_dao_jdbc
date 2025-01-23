package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelDao.DaoFactory;
import modelDao.SellerDao;
import modelEntities.Department;
import modelEntities.Seller;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("TESTE 1: seller findByID ====");

        Seller seller = sellerDao.findByID(3);
        System.out.println(seller);

        System.out.println();
        System.out.println();

        System.out.println("TESTE 2: seller findByDepartment ====");

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println();

        System.out.println("TESTE 3: seller findAll ====");

        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println();

        System.out.println("TESTE 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido, Novo ID = " + newSeller.getID());

        System.out.println();
        System.out.println();

        System.out.println("TESTE 5: seller update ====");
        seller = sellerDao.findByID(1);
        seller.setName("Marta Brasil");
        sellerDao.update(seller);
        System.out.println("Update completo!");

        System.out.println();
        System.out.println();

        System.out.println("TESTE 6: seller delete ====");
        System.out.println("Digite o ID para testar o delete");
        int ID = sc.nextInt();
        sellerDao.deleteByID(ID);
        
    }
}
