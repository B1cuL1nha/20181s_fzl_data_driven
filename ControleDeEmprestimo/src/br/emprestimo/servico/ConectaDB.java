package br.emprestimo.servico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class ConectaDB {
	String url = "jdbc:mysql://localhost:3306/biblioteca";
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root";
	String senha = "alunofatec";
	
	public ConectaDB(String driver, String url, String usuario, String senha){
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public ConectaDB(){
		
	}
	
	public Connection getConection(){
		try {
			Class.forName(driver);
			return (Connection) DriverManager.getConnection(url, usuario,senha);
		} catch (CommunicationsException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
