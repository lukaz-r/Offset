package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafxmvc.model.domain.Categoria;
import javafxmvc.model.domain.Cliente;
import javafxmvc.model.domain.Pacote;

public class PacoteDAO {
	
	
	 private Connection connection;

	    public Connection getConnection() {
	        return connection;
	    }
	    
	 public void setConnection(Connection connection) {
	        this.connection = connection;
	   }
	 
	 public boolean inserir(Pacote pacote) {
		 String sql = "INSERT INTO pacote(nome, preco, validade) VALUES(?,?,?)";
		 
		 try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, pacote.getNome());
	            stmt.setFloat(2, pacote.getPreco());
	            stmt.setString(3, pacote.getValidade()); 
	            stmt.execute();
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(PacoteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
 
		 
	 }
	 
}
