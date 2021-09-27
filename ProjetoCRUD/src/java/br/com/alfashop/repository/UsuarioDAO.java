package br.com.alfashop.repository;

import br.com.alfashop.conex.MinhaConex;
import br.com.alfashop.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfamidia
 */
public class UsuarioDAO 
{
    Connection conn;
    
    //construtor
    public UsuarioDAO() {
        this.conn = MinhaConex.getConnection();
    }
    
    //método para listar todos os usuarios
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from usuarios";
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Usuario obj = new Usuario();
                obj.setIdusuario(rset.getLong("idusuarios"));
                obj.setNome(rset.getString("nome"));
                obj.setEmail(rset.getString("email"));
                //adiciono o obj em uma lista 
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }
        catch(Exception e) {
            lista = null;
        }
        return lista;
    }
    
    
}
