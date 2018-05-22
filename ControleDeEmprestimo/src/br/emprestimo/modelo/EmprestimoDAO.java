package br.emprestimo.modelo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

import br.emprestimo.servico.ConectaDB;

public class EmprestimoDAO {
	//Logger logger = Logger.getLogger(EmprestimoDAO.class);

	public int adiciona(Emprestimo emprestimo) {
		System.out.println(emprestimo.getLivro().getIsbn());
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = new ConectaDB().getConection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into Emprestimo (emprestimoNumero, codigoLivro, codigoUsuario, dataEmprestimo, dataDevolucao) values(?,?,?,?,?)");
			ps.setInt(1, emprestimo.getEmprestimoNumero());
			ps.setString(2, emprestimo.getLivro().getIsbn());
			ps.setString(3, emprestimo.getUsuario().getRa());
			ps.setString(4, emprestimo.getDataEmprestimo());
			ps.setString(5, emprestimo.getDataDevolucao());
			codigoRetorno = ps.executeUpdate();
			//logger.info("codigo de retorno do metodo adiciona empresa = " + codigoRetorno);

			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	} 
	public int exclui (int numeroEmprestimo) {
		java.sql.PreparedStatement ps;
		int codigoretorno = 0;
		try (Connection conn = new ConectaDB().getConection()) {
			ps= conn.prepareStatement ("delete from Emprestimo where emprestimoNumero = ?");
			ps.setInt(1, numeroEmprestimo);
			codigoretorno = ps.executeUpdate();
			}
		catch (SQLException e){
			throw new RuntimeException(e);
		}
	return codigoretorno;
	
	}
}
