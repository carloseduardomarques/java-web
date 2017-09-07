package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "drogaria" ;
	private static final String SENHA = "12345";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection conectar() throws SQLException{
		
	Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

    return conexao;
    
	}
	
	public static void main(String[] args) {
		
		try{
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexao realizada com sucesso!");
			
			}catch(SQLException ex){
				
	        System.out.println("Nao foi possivel realizar a conexao!");
			ex.printStackTrace();	
			}
		}	

}
