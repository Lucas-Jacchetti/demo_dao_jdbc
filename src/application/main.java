package application;

import java.util.Date;
import modelDao.DaoFactory;
import modelDao.SellerDao;
import modelEntities.Department;
import modelEntities.Seller;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {

    
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findByID(3);

        System.out.println(seller);
    }
}
