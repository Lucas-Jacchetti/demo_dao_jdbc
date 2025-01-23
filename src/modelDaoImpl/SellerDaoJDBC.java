package modelDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBexception;
import modelDao.SellerDao;
import modelEntities.Department;
import modelEntities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn; //à disposição em qualquer lugar da classe

    public SellerDaoJDBC(Connection conn){ //dependência
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteByID(Integer ID) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public Seller findByID(Integer ID) {
        PreparedStatement st = null; //prepara e permite um imput de sql futuro
        ResultSet rs = null; //variavel que vai armazenar o resultado

        try {
            st = conn.prepareStatement( "SELECT seller.*,department.Name as DepName "/* busca as duas tabelas (vendedor e departamento), da um apelido para o departamento */
                                        + "FROM seller INNER JOIN department "  /* busca os dados das duas tabelas (vendedor e departamento) */
                                        + "ON seller.DepartmentID = Department.ID " /* ---- */
                                        + "WHERE seller.ID = ? "/* impoe uma restrição sobre qual vendedor vai ser buscado, com base no ID do mesmo*/);
            st.setInt(1, ID);
            rs = st.executeQuery(); //o resulado do comando sql cai nessa variavel resultset
            if(rs.next()){ //navegação pelos dados para instanciar o seller apontando para o department
                
                Department dep = instanciateDepartment(rs);  //instanciação do department
                
                //*Utilizando metodos, facilitando a visualização do código */
                
                Seller obj = instanciateSeller(rs, dep); //instanciação do seller que apontará para o department
                
                return obj;
            }
            return null;
        } 
        catch (SQLException e) {
            throw new DBexception(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    //*metodo de instanciação do Department */
    private Department instanciateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setID(rs.getInt("DepartmentID"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    //*metodo de instanciação do Seller */
    private Seller instanciateSeller(ResultSet rs, Department dep) throws SQLException{
        Seller obj = new Seller();
        obj.setID(rs.getInt("ID"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthdate(rs.getDate("BirthDate"));
        obj.setDepartment(dep); //associação
        return obj;

    }

    public List<Seller> findByDepartment(Department department){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement( 
                                        "SELECT seller.*,department.Name as DepName "
                                        + "FROM seller INNER JOIN department "
                                        + "ON seller.departmentID = department.ID "
                                        + "WHERE departmentID = ? "
                                        + "ORDER BY name"
                                        );
            st.setInt(1, department.getID());
            rs = st.executeQuery(); //o resulado do comando sql cai nessa variavel resultset
            
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            
            while (rs.next()){ //navegação pelos dados para instanciar o seller apontando para o department
                //*Mesmo departamento, com 1 ou mais vendedores apontando pra ele */
                Department dep = map.get(rs.getInt("DepartmentID"));  // caso ja exista, o map.get pega ele, reutilizando                              
                
                if (dep == null) { // se o departamento não existir, faz a instanciação
                    dep = instanciateDepartment(rs);
                    map.put(rs.getInt("DepartmentID"), dep); //salva o departamento no map
                }
                
                Seller obj = instanciateSeller(rs, dep); //instanciação do seller que apontará para o department
                list.add(obj);
                
            }
            return list;
        } 
        catch (SQLException e) {
            throw new DBexception(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
