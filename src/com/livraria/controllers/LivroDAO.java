package com.livraria.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.livraria.models.Livro;


public class LivroDAO {

	private String login = "root";
	private String senha = "root";
	private String url = "jdbc:mysql://localhost/livraria";
	private Connection conexao;
	private PreparedStatement pstm;
	private AutorDAO autorDAO= new AutorDAO();
	
	public boolean cadastrarLivro(Livro l) {
		
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "insert into livros values (null, ? , ? , ? ,? )";
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, l.getTitulo());
			pstm.setString(2, l.getEditora());
			pstm.setInt(3,l.getAutor().getId());
			pstm.setDouble(4, l.getPreco());
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
	
	public Vector<Livro> getTodosLivros() {
		try {
			Vector<Livro> Livros = new Vector<Livro>();
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "select * from livros order by titulo";
			pstm = conexao.prepareStatement(sql);
			ResultSet todosLivros = pstm.executeQuery();
			while( todosLivros.next() ) {
				Livro l = new Livro();
				l.setId( todosLivros.getInt("id") );
				l.setTitulo( todosLivros.getString("titulo") );
				l.setEditora( todosLivros.getString("editora") );
				l.setAutor( autorDAO.getTodosAutores().get(todosLivros.getInt("autor_id")));
				l.setPreco(todosLivros.getFloat("preco"));
				Livros.add(l);
			}
			return Livros;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean apagarLivro(int idLivro) {
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "delete from livros where id = ?";
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idLivro);
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

	public boolean atualizarLivro(Livro l) {
		try {
			conexao = DriverManager.getConnection(url, login, senha);
			String sql = "update Livros set titulo=?, editora=?, " +
					"autor_id=? , preco=? where id=?";
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, l.getTitulo());
			pstm.setString(2, l.getEditora());
			pstm.setInt(3, l.getAutor().getId());
			pstm.setDouble(4, l.getPreco());
			pstm.setInt(5, l.getId());
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
