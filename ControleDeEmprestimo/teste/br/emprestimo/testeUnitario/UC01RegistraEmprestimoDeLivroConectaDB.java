package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.EmprestimoDAO;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ConectaDB;
import br.emprestimo.servico.ServicoEmprestimo;

public class UC01RegistraEmprestimoDeLivroConectaDB {

	@Test
	public void conexaoComSucesso() {
		//cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "alunofatec";
		
		//acao
		ConectaDB conectaDB = new ConectaDB(driver, url, usuario, senha);
		
		//verificacao
		assertNotNull(conectaDB.getConection());
	}

	@Test
	public void registraEmprestimoComSucesso(){
		//cenario
		Emprestimo umEmprestimo = new Emprestimo();
		Usuario umUsuario = ObtemUsuario.comDadosValidos();
		Livro umLivro = ObtemLivro.comDadosValidos();
		ServicoEmprestimo servico = new ServicoEmprestimo();
		umEmprestimo = servico.empresta(umLivro, umUsuario);
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		
		//acao
		int resultadoEsperado = emprestimoDAO.adiciona(umEmprestimo);
		
		//
		assertEquals(1, resultadoEsperado);
	}
	
	
}
