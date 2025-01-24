package modelDaoImpl;

import java.sql.Statement;
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
import java.util.List;
import modelDao.DepartmentDao;
import modelEntities.Department;

@SuppressWarnings("unused")
public class DepartmentDaoJDBC implements DepartmentDao{

    private Connection conn; //à disposição em qualquer lugar da classe

    public DepartmentDaoJDBC(Connection conn){ //dependência
        this.conn = conn;
    }



    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("INSERT INTO Department "
                                    + "(Name, ID) "
                                    + "VALUES "
                                    + "(?, ?)",
                                    Statement.RETURN_GENERATED_KEYS
                                    );
            st.setString(1, obj.getName()); //configuração dos placeholders (?)
            st.setInt(2, obj.getID());

            int rowsAffected = st.executeUpdate(); //executa o sql

            if (rowsAffected > 0) { //se for maior do que 0, inseriu
                ResultSet rs = st.getGeneratedKeys(); //recebe os dados
                if (rs.next()) {
                    int ID = rs.getInt(1);
                    obj.setID(ID); //atribuir o ID gerado no obj
                }
                DB.closeResultSet(rs);
            }
            else{
                throw new DBexception("Erro, nenhuma linha foi adicionada!");
            }
        }
        catch (SQLException e){
            throw new DBexception(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
            
    }
    
    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("UPDATE Department " //atualiza
                                    + "SET Name = ? "
                                    + "WHERE ID = ?");
            st.setString(1, obj.getName());
            st.setInt(2, obj.getID());

            st.executeUpdate(); //faz a operação sql
        }
        catch (SQLException e){
            throw new DBexception(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteByID(Integer ID) {
    }

    @Override
    public Department findByID(Integer ID) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department WHERE ID = ?");
            st.setInt(1, ID);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instanciateDepartment(rs);
                return dep;
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

    private Department instanciateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setID(rs.getInt("ID"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
            return null;
    }
    
}
