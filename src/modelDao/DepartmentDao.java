package modelDao;

import java.util.List;

import modelEntities.Department;

public interface DepartmentDao {
    
    void insert(Department obj); //insere no banco de dados o objeto dado como parâmetroS
    void update(Department obj); //atualiza uma informação passada de parâmetro 
    void deleteByID(Integer ID); //deleta um departamento passado com base no id
    Department findByID(Integer ID); //consulta no banco de dados um objeto com o ID passado
    List<Department> findAll(); //cria uma lista, retornando todos os departamentos
    
}
