package com.livraria.views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TelaFrame extends JFrame  implements ActionListener {
	private JMenuBar barraMenu;
	private JMenu menuCadastrar;
	private JMenuItem itemCadastrarLivro;
	private JMenuItem itemCadastrarAutor;
	private JMenu menuConsultar;
	private JMenu itemConsultarLivros;
	private JMenuItem subitemLivrosPorNome;
	private JMenuItem subitemLivrosPorAutor;
	private JMenu itemConsultarAutor;
	private JMenuItem subitemAutorPorNome;
	private JMenuItem subitemAutorPorCpf;
	private JMenu menuExluir;
	private JMenuItem itemExluirAutor;
	private JMenuItem itemExluirLivros;

	public TelaFrame() {
		setTitle("Sistemas de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 399);
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuCadastrar = new JMenu("Cadastrar");
		barraMenu.add(menuCadastrar);
		
		itemCadastrarLivro = new JMenuItem("Livro");
		itemCadastrarLivro.addActionListener(this);
		menuCadastrar.add(itemCadastrarLivro);
		
		itemCadastrarAutor = new JMenuItem("Autor");
		itemCadastrarAutor.addActionListener(this);
		menuCadastrar.add(itemCadastrarAutor);
		
		menuConsultar = new JMenu("Consultar");
		barraMenu.add(menuConsultar);
		
		itemConsultarLivros = new JMenu("Livros");
		menuConsultar.add(itemConsultarLivros);
		
		subitemLivrosPorNome = new JMenuItem("Por Nome");
		itemConsultarLivros.add(subitemLivrosPorNome);
		
		subitemLivrosPorAutor = new JMenuItem("Por Autor");
		itemConsultarLivros.add(subitemLivrosPorAutor);
		
		itemConsultarAutor = new JMenu("Autor");
		menuConsultar.add(itemConsultarAutor);
		
		subitemAutorPorNome = new JMenuItem("Por Nome");
		itemConsultarAutor.add(subitemAutorPorNome);
		
		subitemAutorPorCpf = new JMenuItem("Por CPF");
		itemConsultarAutor.add(subitemAutorPorCpf);
		
		menuExluir = new JMenu("Exluir");
		barraMenu.add(menuExluir);
		
		itemExluirLivros = new JMenuItem("Livros");
		menuExluir.add(itemExluirLivros);
		
		itemExluirAutor = new JMenuItem("Autor");
		menuExluir.add(itemExluirAutor);
		getContentPane().setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == itemCadastrarAutor){
			setContentPane(new CadastrarAutorPanel(this,null));
			validate();
		}else if (evento.getSource() == itemCadastrarLivro){
			setContentPane(new CadastrarLivroPanel());
			validate();
		}
		
	}
}