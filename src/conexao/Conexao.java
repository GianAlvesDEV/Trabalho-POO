package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
     public static Connection getConexao() 
   {
       Connection conexao=null;
       try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/construcao_civil","root","1234");
       }catch(SQLException e ){
           System.out.print("\n Erro ao conectar: "+e.toString());
       }
       return(conexao);
    }
}
