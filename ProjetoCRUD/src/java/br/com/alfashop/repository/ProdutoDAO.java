package br.com.alfashop.repository;

import br.com.alfashop.conex.MinhaConex;
import br.com.alfashop.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfamidia
 */
public class ProdutoDAO 
{
    Connection conn;
    
    //construtor
    public ProdutoDAO() {
        this.conn = MinhaConex.getConnection();
    }
    
    //método para listar todos os produtos
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<Produto>();
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from produtos";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Produto obj = new Produto();
                obj.setIdproduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisinfo(rset.getString("maisinfo"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setValor(rset.getFloat("valor"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setCatid(rset.getLong("categorias_idcategorias"));
                //adiciono o obj em uma lista 
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            lista = null;
        }
        return lista;
    }
    //método para ser acessado via JavaBean
    public List<Produto> getLista() {
        return listar();
    }
    
    
    //método para buscar produtos conforme o filtro
    public List<Produto> buscar(String filtro) {
        List<Produto> lista = new ArrayList<Produto>();
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select p.*, c.nome as catnome from produtos p, categorias c "
                        + "where categorias_idcategorias = idcategorias and "+filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Produto obj = new Produto();
                obj.setIdproduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisinfo(rset.getString("maisinfo"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setValor(rset.getFloat("valor"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setCatid(rset.getLong("categorias_idcategorias"));
                obj.setCatnome(rset.getString("catnome"));
                //adiciono o obj em uma lista 
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            lista = null;
        }
        return lista;
    }
    //método para ser acessado via JavaBean
    public List<Produto> getDestaques() {
        return buscar("destaque='s'");
    }
    
    
    //método para buscar UM produto pelo ID
    public Produto buscarPorId(Long idp) {
        Produto obj = new Produto();
        try {
            String sql = "select * from produtos where idprodutos = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, idp);
            ResultSet rset = stmt.executeQuery();
            if (rset.next()) {
                obj.setIdproduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisinfo(rset.getString("maisinfo"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setValor(rset.getFloat("valor"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setCatid(rset.getLong("categorias_idcategorias"));
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            obj = null;
        }
        return obj;
    }
}
