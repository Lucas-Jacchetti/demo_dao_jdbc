package modelDao;

import java.util.List;

import modelEntities.Department;
import modelEntities.Seller;

public interface SellerDao {
    
    void insert(Seller obj); //insere no banco de dados o objeto dado como parâmetroS
    void update(Seller obj); //atualiza uma informação passada de parâmetro 
    void deleteByID(Integer ID); //deleta um departamento passado com base no id
    Seller findByID(Integer ID); //consulta no banco de dados um objeto com o ID passado
    List<Seller> findAll(); //cria uma lista, retornando todos os departamentos
    List<Seller> findByDepartment(Department department);
}
