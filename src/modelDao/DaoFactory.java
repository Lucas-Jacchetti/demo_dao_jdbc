package modelDao;

import db.DB;
import modelDaoImpl.DepartmentDaoJDBC;
import modelDaoImpl.SellerDaoJDBC;

public class DaoFactory { //operações estaticas para implementao o Dao
    
    public static SellerDao createSellerDao(){ //injeção de dependência, facilita manutenção e praticidade, ja que se nao fosse utilizada mais a implementação SellerDaoJDBC, todas as suas instancias teriam que ser mudadas pela nova classe. 
                                              //dessa maneira é possível alterar apenas a classe factory, que fara a injeção de dependência
        return new SellerDaoJDBC(DB.getConnection());
        
    }

    public static DepartmentDao createDepartmentDao(){
        
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
