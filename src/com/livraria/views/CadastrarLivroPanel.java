package com.livraria.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.livraria.controllers.AutorDAO;
import com.livraria.controllers.LivroDAO;
import com.livraria.models.Livro;

public class CadastrarLivroPanel extends JPanel implements ActionListener {

	private JTextField txtTitulo;
	private JTextField txtEditora;
	private JTextField txtPreco;
	private JLabel lblEditora;
	private JLabel lblCadastrarLivro;
	private JComboBox cbnAutor;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblPreco;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private AutorDAO autorDAO = new AutorDAO();
	private LivroDAO livroDAO = new LivroDAO();
	private Livro l = new Livro();

	public CadastrarLivroPanel() {
		setLayout(null);
		
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(205, 86, 45, 15);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(250, 84, 188, 19);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(194, 113, 56, 15);
		add(lblEditora);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(250, 113, 188, 19);
		add(txtEditora);
		txtEditora.setColumns(10);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(204, 140, 46, 15);
		add(lblAutor);
		
		cbnAutor = new JComboBox();
		cbnAutor.setBounds(250, 135, 188, 24);
		cbnAutor.setModel(new DefaultComboBoxModel(autorDAO.getTodosAutores()));
		add(cbnAutor);
		
		lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(205, 167, 45, 15);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(250, 165, 188, 19);
		add(txtPreco);
		txtPreco.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(191, 222, 117, 25);
		btnCadastrar.addActionListener(this);
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(343, 222, 117, 25);
		add(btnLimpar);
		
		lblCadastrarLivro = new JLabel("CADASTRAR LIVRO");
		lblCadastrarLivro.setBounds(141, 12, 222, 15);
		add(lblCadastrarLivro);
	}


	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnCadastrar ){
			l.setTitulo(txtTitulo.getText());
			l.setEditora(txtEditora.getText());
			l.setAutor(autorDAO.getTodosAutores().get(cbnAutor.getSelectedIndex()));
			l.setPreco(Double.parseDouble(txtPreco.getText()));
			if( livroDAO.cadastrarLivro(l) )
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO no cadastro do Livro!");
		}
		
	}
		

}


