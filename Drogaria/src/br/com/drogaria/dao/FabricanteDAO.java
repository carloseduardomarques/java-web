package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {

	public void salvar(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES(?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getDescricao());

		comando.executeUpdate();
	}
	
	private static void teste_salvar(){
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 1");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 2");

		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("OS fabricantes foram salvos com sucesso!");
		} catch (SQLException e) {
			System.out
					.println("Ocorreu um erro ao tentar salvar um dos fabricantes!");
			e.printStackTrace();
		}
		
	}

	public void excluir(Fabricante f) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();

	}
	
private static void teste_excluir(){
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(2L);

		Fabricante f2 = new Fabricante();
		f2.setCodigo(5L);

		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("OS fabricantes foram removidos com sucesso!");
		} catch (SQLException e) {
			System.out
					.println("Ocorreu um erro ao tentar remover um dos fabricantes!");
			e.printStackTrace();
		}
		
	}

  public void editar(Fabricante f)throws SQLException {
	  
   StringBuilder sql = new StringBuilder();
	  
  sql.append("UPDATE fabricante ");
  sql.append("SET descricao = ? ");
  sql.append("WHERE codigo = ? ");
  
  Connection conexao = ConexaoFactory.conectar();
  
  PreparedStatement comando = conexao.prepareStatement(sql.toString());
  
  comando.setString(1, f.getDescricao());
  comando.setLong(2, f.getCodigo());
  
  comando.executeUpdate();
  	  
  }  
  
  private static void teste_editar(){
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		f1.setDescricao("DESCRICAO ATUALIZADA");

		FabricanteDAO fdao = new FabricanteDAO();

		try {
			fdao.editar(f1);			
			System.out.println("O fabricante foi atualizado com sucesso!");
		} catch (SQLException e) {		
			System.out.println("Ocorreu um erro ao a um dos fabricantes!");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		/*teste_salvar();
		teste_excluir();*/	
		teste_editar();

	}

}
