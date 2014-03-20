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
import java.awt.Font;

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
	private JButton btnVoltar;
	private JButton btnAlterar;
	private AutorDAO autorDAO = new AutorDAO();
	private LivroDAO livroDAO = new LivroDAO();
	private Livro l;
	private TelaFrame container;

	public CadastrarLivroPanel(TelaFrame container,Livro l) {
		this.l =l;
		this.container = container;
		setLayout(null);
		
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(161, 73, 45, 15);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(206, 71, 251, 19);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setBounds(150, 109, 56, 15);
		add(lblEditora);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(206, 109, 251, 19);
		add(txtEditora);
		txtEditora.setColumns(10);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(160, 152, 46, 15);
		add(lblAutor);
		
		cbnAutor = new JComboBox();
		cbnAutor.setBounds(206, 147, 251, 24);
		cbnAutor.setModel(new DefaultComboBoxModel(autorDAO.getTodosAutores()));
		add(cbnAutor);
		
		lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(162, 191, 45, 15);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(207, 189, 250, 19);
		add(txtPreco);
		txtPreco.setColumns(10);
				
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(329, 238, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblCadastrarLivro = new JLabel("CADASTRAR LIVRO");
		lblCadastrarLivro.setFont(new Font("Ubuntu", Font.BOLD, 25));
		lblCadastrarLivro.setBounds(194, 12, 241, 33);
		add(lblCadastrarLivro);
		
		if(l == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(171, 238, 117, 25);
			btnCadastrar.addActionListener(this);
			add(btnCadastrar);
					
		}
		else {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(171, 238, 117, 25);
			btnAlterar.addActionListener(this);
			add(btnAlterar);
			
			txtTitulo.setText(l.getTitulo() );
			txtEditora.setText(l.getEditora() );
			cbnAutor.setSelectedItem(l.getAutor());
			txtPreco.setText(String.valueOf(l.getPreco()));
		}
	}


	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnCadastrar ){
			l = new Livro();
			l.setTitulo(txtTitulo.getText());
			l.setEditora(txtEditora.getText());
			l.setAutor(autorDAO.getTodosAutores().get(cbnAutor.getSelectedIndex()));
			l.setPreco(Double.parseDouble(txtPreco.getText()));
			if( livroDAO.cadastrarLivro(l) ){
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
				VisualizarLivrosPanel panelVerLivros = new VisualizarLivrosPanel(container);
				setVisible(false);
				container.setContentPane(panelVerLivros);
				container.validate();
			}else
				JOptionPane.showMessageDialog(null, "ERRO no cadastro do Livro!");
		}else if(evento.getSource() == btnAlterar){
			l.setTitulo(txtTitulo.getText());
			l.setEditora(txtEditora.getText());
			l.setAutor(autorDAO.getTodosAutores().get(cbnAutor.getSelectedIndex()));
			l.setPreco(Double.parseDouble(txtPreco.getText()));
			
			if( livroDAO.atualizarLivro(l) ){
				JOptionPane.showMessageDialog(null, "Livro atualizado com sucesso!");
				VisualizarLivrosPanel panelVerLivros = new VisualizarLivrosPanel(container);
				setVisible(false);
				container.setContentPane(panelVerLivros);
				container.validate();
			}else
				JOptionPane.showMessageDialog(null, "ERRO na atualização do Livro!");
		}
		else if(evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			setVisible(false);
			container.setContentPane(panelinicial);
			container.validate();
		}
		
	}
		

}


