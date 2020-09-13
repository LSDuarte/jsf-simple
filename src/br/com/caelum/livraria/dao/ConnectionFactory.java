package br.com.caelum.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=livraria;integratedSecurity=true";

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL);
			System.out.println("Conectando ao Banco = " + con);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao conectar no banco.  Error: " + e.getMessage());
		}
		
	}
}