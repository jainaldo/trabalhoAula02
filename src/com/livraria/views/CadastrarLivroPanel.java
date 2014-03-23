package com.livraria.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.livraria.controllers.AutorDAO;
import com.livraria.controllers.LivroDAO;
import com.livraria.models.Autor;
import com.livraria.models.Livro;

public class CadastrarLivroPanel extends JPanel implements ActionListener {

	private JTextField txtTitulo;
	private JTextField txtEditora;
	private JTextField txtPreco;
	private JLabel lblEditora;
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
	private JLabel lblTituloPanel;
	private Vector<Autor> todosAutores;

	public CadastrarLivroPanel(TelaFrame container,Livro l) {
		this.l =l;
		this.container = container;
		setBounds(100, 100, 619, 399);
		setBackground(new Color(63,73,68));
		setLayout(null);
		
		
		lblTitulo = new JLabel("Título:");
		lblTitulo.setForeground(new Color(246,245,237));
		lblTitulo.setBounds(161, 93, 45, 15);
		add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBackground(new Color(246,245,237));
		txtTitulo.setBounds(206, 91, 261, 19);
		add(txtTitulo);
		txtTitulo.setColumns(10);
		
		lblEditora = new JLabel("Editora:");
		lblEditora.setForeground(new Color(246,245,237));
		lblEditora.setBounds(150, 129, 56, 15);
		add(lblEditora);
		
		txtEditora = new JTextField();
		txtEditora.setBackground(new Color(246,245,237));
		txtEditora.setBounds(206, 129, 261, 19);
		add(txtEditora);
		txtEditora.setColumns(10);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(new Color(246,245,237));
		lblAutor.setBounds(160, 172, 46, 15);
		add(lblAutor);
		
		AutorDAO autorDAO = new AutorDAO();
		todosAutores = autorDAO.getTodosAutores();
		
		cbnAutor = new JComboBox();
		cbnAutor.setBackground(new Color(246,245,237));
		cbnAutor.setBounds(206, 167, 261, 24);
		cbnAutor.setModel(new DefaultComboBoxModel(todosAutores));
		add(cbnAutor);
		
		lblPreco = new JLabel("Preço:");
		lblPreco.setForeground(new Color(246,245,237));
		lblPreco.setBounds(162, 211, 45, 15);
		add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBackground(new Color(246,245,237));
		txtPreco.setBounds(207, 209, 260, 19);
		add(txtPreco);
		txtPreco.setColumns(10);
				
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(329, 258, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblTituloPanel = new JLabel("Cadastrar Novo Livro");
		lblTituloPanel.setForeground(new Color(246,245,237));
		lblTituloPanel.setFont(new Font("Ubuntu", Font.BOLD, 38));
		lblTituloPanel.setBounds(119, 12, 397, 44);
		add(lblTituloPanel);
		
		if(l == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(171, 258, 117, 25);
			btnCadastrar.addActionListener(this);
			add(btnCadastrar);
					
		}
		else {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(171, 258, 117, 25);
			btnAlterar.addActionListener(this);
			add(btnAlterar);
			
			txtTitulo.setText(l.getTitulo() );
			txtEditora.setText(l.getEditora() );
			for (int i = 0; i < todosAutores.size(); i++) {
				if(todosAutores.get(i).getId() == l.getAutor().getId()){
					cbnAutor.setSelectedIndex(i);
					break;
				}
				
			}
			cbnAutor.setSelectedItem(l.getAutor().getId());
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
				container.setContentPane(panelVerLivros);
				container.validate();
			}else
				JOptionPane.showMessageDialog(null, "ERRO na atualização do Livro!");
		}
		else if(evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			container.setContentPane(panelinicial);
			container.validate();
		}
		
	}
		

}


