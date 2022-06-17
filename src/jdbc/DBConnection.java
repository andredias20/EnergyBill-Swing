package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private final String adress ="localhost";
    private final String database ="consumo_energia";
    private final String user ="root";
    private final String password ="";

    /**
     * This method returns the an interface object 'Connection' to help
     * @return Connection - Java SQL Interface
     */
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://"+adress+"/"+database+"?userSSL=false",user, password);
        }catch(SQLException ex){
            System.out.println("Erro ao tentar realizar conexão com o banco de dados");
            System.out.println("\n--- START ---\n"+ex.getMessage()+"\n--- END ---\n");
            throw new RuntimeException(ex);
            
        }
        
    }
}
