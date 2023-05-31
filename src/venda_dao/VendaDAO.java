package venda_dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import principal.DonoDaCasa;
import principal.Venda;

public class VendaDAO {
    Connection conexao;

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public VendaDAO() throws SQLException, ClassNotFoundException
   {
      this.conexao = Conexao.getConexao();
   }
    
    public void adicionarVenda(Venda venda)
   {
      PreparedStatement ps_estado;
      String msgSql = "insert into Venda(cod_venda,fk_cpf,fk_cod_residencia,dataDaVenda,valor) values(?,?,?,?,?)";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        ps_estado.setString(1, venda.getCod_venda());
        ps_estado.setString(2, venda.getFk_cpf());
        ps_estado.setInt(3, venda.getFk_cod_residencia());
        ps_estado.setString(4, venda.getDataDaVenda().toString());
        ps_estado.setFloat(5, venda.getValor());
        
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao adicionar a venda... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao inserir no banco: "+e.toString());
      }
   }
   public ArrayList<Venda> ListaCompleta3()
   {
       PreparedStatement ps_estado;
       ResultSet result;
       ArrayList<Venda> listaVenda = null;
       String msgSql = "select * from Venda";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            result = ps_estado.executeQuery();
            listaVenda = new ArrayList<>();
            while(result.next())
            {
                Venda venda = new Venda();
                venda.setCod_venda(result.getString("cod_venda"));
                venda.setFk_cpf(result.getString("fk_cpf"));
                venda.setFk_cod_residencia(result.getInt("fk_cod_residencia"));
                venda.setValor(result.getFloat("valor"));
                listaVenda.add(venda);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            result.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar todos no banco: "+e.toString());
       }
       return (listaVenda);
   }
   
   public void remover(String cod_venda)
   {
       PreparedStatement ps_estado;
       String msgSql = "delete from Venda where cod_venda = ?";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            ps_estado.setString(1, cod_venda);
            ps_estado.execute();
            ps_estado.close();
            System.out.println("\n Informacao removida com sucesso.");
       }catch(SQLException e){
          System.out.print("\n Erro ao remover do banco: "+e.toString());
       }
   }
   
   public void alterar (Venda venda)
   {
      PreparedStatement ps_estado;
      String msgSql = "update Venda set fk_cpf=?, fk_cod_residencia=?, dataDaVenda=?, valor=?, where cod_venda=?";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        
        ps_estado.setString(1, venda.getFk_cpf());
        ps_estado.setInt(2, venda.getFk_cod_residencia());
        ps_estado.setString(3, venda.getDataDaVenda().toString());
        ps_estado.setFloat(4, venda.getValor());
        ps_estado.setString(5, venda.getCod_venda());
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao alterar a venda... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao alterar no banco: "+e.toString());
      }
   }
}
