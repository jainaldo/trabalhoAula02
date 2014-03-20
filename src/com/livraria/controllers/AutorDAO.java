package com.livraria.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.livraria.models.Autor;


public class AutorDAO {

	private String login = "root";
	private String senha = "root";
	private String url = "jdbc:mysql://localhost/livraria";
	private Connection conexao;
	private PreparedStatement pstm;
	
	public boolean cadastrarAutor(Autor a) {
		
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "insert into autores values (null, ? , ? , ?  )";
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, a.getNome());
			pstm.setString(2, a.getCpf());
			pstm.setString(3, a.getTelefone());
			int resultado = pstm.executeUpdate();
			pstm.close();
			conexao.close();
			if( resultado > 0 )
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}				
	}
	
	public Vector<Autor> getTodosAutores() {
		try {
			Vector<Autor> autores = new Vector<Autor>();
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "select * from autores order by id";
			pstm = conexao.prepareStatement(sql);
			ResultSet todosAutores = pstm.executeQuery();
			while( todosAutores.next() ) {
				Autor a = new Autor();
				a.setId( todosAutores.getInt("id") );
				a.setNome( todosAutores.getString("nome") );
				a.setCpf( todosAutores.getString("cpf") );
				a.setTelefone( todosAutores.getString("telefone") );
				autores.add(a);
			}
			return autores;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean apagarAutor(int idAutor) {
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "delete from autores where id = ?";
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idAutor);
			int resultado = pstm.executeUpdate();
			pstm.close();
			conexao.close();
			if(resultado > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean atualizarAutor(Autor a) {
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "update autores set nome=?, cpf=?, " +
					"telefone=? where id=?";
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, a.getNome());
			pstm.setString(2, a.getCpf());
			pstm.setString(3, a.getTelefone());
			pstm.setInt(4, a.getId());
			int resultado = pstm.executeUpdate();
			pstm.close();
			conexao.close();
			if( resultado > 0 )
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

}
