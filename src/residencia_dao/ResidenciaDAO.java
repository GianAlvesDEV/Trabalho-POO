package residencia_dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import principal.DonoDaCasa;
import principal.Residencia;


public class ResidenciaDAO {
    Connection conexao;

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResidenciaDAO() throws SQLException, ClassNotFoundException
   {
      this.conexao = Conexao.getConexao();
   }
    
    public void adicionarResidencia(Residencia residencia)
   {
      PreparedStatement ps_estado;
      String msgSql = "insert into Residencia(cod_residencia,area,endereco) values(?,?,?)";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        ps_estado.setInt(1, residencia.getCod_residencia());
        ps_estado.setFloat(2, residencia.getArea());
        ps_estado.setString(3, residencia.getEndereco());
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao adicionar a residencia... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao inserir no banco: "+e.toString());
      }
   }
    
    public ArrayList<Residencia> ListaCompleta1()
   {
       PreparedStatement ps_estado;
       ResultSet result;
       ArrayList<Residencia> listaResidencia = null;
       String msgSql = "select * from Residencia";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            result = ps_estado.executeQuery();
            listaResidencia = new ArrayList<>();
            while(result.next())
            {
                Residencia residencia = new Residencia();
                residencia.setCod_residencia(result.getInt("cod_residencia"));
                residencia.setArea(result.getFloat("area"));
                residencia.setEndereco(result.getString("endereco"));
                listaResidencia.add(residencia);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            result.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar todos no banco: "+e.toString());
       }
       return (listaResidencia);
   }
    
   public void remover(int cod_residencia)
   {
       PreparedStatement ps_estado;
       String msgSql = "delete from Residencia where cod_residencia = ?";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            ps_estado.setInt(1, cod_residencia);
            ps_estado.execute();
            ps_estado.close();
            System.out.println("\n Informacao removida com sucesso.");
       }catch(SQLException e){
          System.out.print("\n Erro ao remover do banco: "+e.toString());
       }
   }
   
   public void alterar (Residencia residencia)
   {
      PreparedStatement ps_estado;
      String msgSql = "update Residencia set area=?, endereco=? where cod_residencia=?";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        
        ps_estado.setFloat(1, residencia.getArea());
        ps_estado.setString(2, residencia.getEndereco());
        ps_estado.setInt(3, residencia.getCod_residencia()); 
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao alterar a residencia... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao alterar no banco: "+e.toString());
      }
   }
}
