package db;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DB {

    private static Connection conn = null;


    //* inicia a conexão com banco de dados
    public static Connection getConnection(){
        if (conn == null) {
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                
                conn = DriverManager.getConnection(url, props);
            }catch (SQLException e){
                e.printStackTrace();
                throw new DBexception(e.getMessage());
                
            }
        }
        return conn;
    }

    //* fecha conexão com banco de dados
    public static void closeConnection(){
        if (conn != null) {
            try{
                conn.close();
            } catch(SQLException e){
                throw new DBexception(e.getMessage());
            }
        }
    }
    
    //* pega as propiedades para iniciar a conexão
    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("c:\\Users\\lucas\\OneDrive\\Documentos\\Programação\\Projetos (geral)\\Java\\demo-dao-jdbc\\db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DBexception(e.getMessage());
        }
    }

    //* fecha um Statement st
    public static void closeStatement(Statement st){
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DBexception(e.getMessage());
            }
        }
    }

    //* fecha um resultSet rs
    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DBexception(e.getMessage());
            }
        }
    }

}
