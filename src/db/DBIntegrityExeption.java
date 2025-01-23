package db;

public class DBIntegrityExeption extends RuntimeException{
    
    public DBIntegrityExeption(String msg){
        super(msg);
    }

}
