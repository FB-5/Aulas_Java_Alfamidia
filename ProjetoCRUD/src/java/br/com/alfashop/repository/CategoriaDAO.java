package br.com.alfashop.repository;

import br.com.alfashop.conex.MinhaConex;
import br.com.alfashop.model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfamidia
 */
public class CategoriaDAO 
{
    Connection conn;
    
    //construtor
    public CategoriaDAO() {
        this.conn = MinhaConex.getConnection();
    }
    
    //método para listar todos as categorias
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from categorias";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Categoria obj = new Categoria();
                obj.setIdcategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
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
    public List<Categoria> getLista() {
        return listar();
    }
}
