package dono_dao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import principal.DonoDaCasa;

public class DonoDAO {
    Connection conexao;

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DonoDAO() throws SQLException, ClassNotFoundException
   {
      this.conexao = Conexao.getConexao();
   }
    
    public void adicionarDono(DonoDaCasa dono)
   {
      PreparedStatement ps_estado;
      String msgSql = "insert into DonoDaCasa(cpf,nome,telefone,renda_mensal) values(?,?,?,?)";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        ps_estado.setString(1, dono.getCpf());
        ps_estado.setString(2, dono.getNome());
        ps_estado.setString(3, dono.getTelefone());
        ps_estado.setFloat(4, dono.getRenda_mensal());
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao adicionar o dono da casa... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao inserir no banco: "+e.toString());
      }
   }
   
   public ArrayList<DonoDaCasa> ListaCompleta()
   {
       PreparedStatement ps_estado;
       ResultSet result;
       ArrayList<DonoDaCasa> listaDono = null;
       String msgSql = "select * from DonoDaCasa";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            result = ps_estado.executeQuery();
            listaDono = new ArrayList<>();
            while(result.next())
            {
                DonoDaCasa dono = new DonoDaCasa();
                dono.setCpf(result.getString("cpf"));
                dono.setNome(result.getString("nome"));
                dono.setTelefone(result.getString("telefone"));
                dono.setRenda_mensal(result.getFloat("renda_mensal"));
                listaDono.add(dono);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            result.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar todos no banco: "+e.toString());
       }
       return (listaDono);
   }
   
   public void remover(String cpf)
   {
       PreparedStatement ps_estado;
       String msgSql = "delete from DonoDaCasa where cpf = ?";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            ps_estado.setString(1, cpf);
            ps_estado.execute();
            ps_estado.close();
            System.out.println("\n Informacao removida com sucesso.");
       }catch(SQLException e){
          System.out.print("\n Erro ao remover do banco: "+e.toString());
       }
   }
   
   public void alterar (DonoDaCasa dono)
   {
      PreparedStatement ps_estado;
      String msgSql = "update DonoDaCasa set nome=?, telefone=?, renda_mensal=? where cpf=?";
      try{
        ps_estado =  this.conexao.prepareStatement(msgSql);
        
        ps_estado.setString(1, dono.getNome());
        ps_estado.setString(2, dono.getTelefone());
        ps_estado.setFloat(3, dono.getRenda_mensal());
        ps_estado.setString(4, dono.getCpf());
        ps_estado.execute();
        ps_estado.close();
        System.out.print("\n Sucesso ao alterar o dono da casa... ");
      }catch(SQLException e){
          System.out.print("\n Erro ao alterar no banco: "+e.toString());
      }
   }
   
    public ArrayList<DonoDaCasa> ListaOrdenada()
   {
       PreparedStatement ps_estado;
       ResultSet result;
       ArrayList<DonoDaCasa> listaDono = null;
       String msgSql = "select * from DonoDaCasa order by nome";
       try{
            ps_estado = this.conexao.prepareStatement(msgSql);
            result = ps_estado.executeQuery();
            listaDono = new ArrayList<>();
            while(result.next())
            {
                DonoDaCasa dono = new DonoDaCasa();
                dono.setCpf(result.getString("cpf"));
                dono.setNome(result.getString("nome"));
                dono.setTelefone(result.getString("telefone"));
                dono.setRenda_mensal(result.getFloat("renda_mensal"));
                listaDono.add(dono);
            }
            System.out.println("\n Informacao buscada com sucesso.");
            result.close();
            ps_estado.close();
       }catch(SQLException e){
            System.out.print("\n Erro ao buscar todos no banco: "+e.toString());
       }
       return (listaDono);
   }
   
   
      
}
