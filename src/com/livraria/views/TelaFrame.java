package com.livraria.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class TelaFrame extends JFrame  implements ActionListener {
	private JMenuBar barraMenu;
	private JMenu menuNovo;
	private JMenuItem itemNovoLivro;
	private JMenuItem itemNovoAutor;
	private JMenu menuVer;
	private JMenuItem itemVerLivros;
	private JMenuItem itemVerAutores;
	private JMenu menuAlterar;
	private JMenuItem itemAlterarAutor;
	private JMenuItem itemAlterarLivro;

	public TelaFrame() {
		setTitle("Sistemas de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 399);
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		menuNovo = new JMenu("Novo");
		barraMenu.add(menuNovo);
		
		itemNovoLivro = new JMenuItem("Livro");
		itemNovoLivro.addActionListener(this);
		
		itemNovoAutor = new JMenuItem("Autor");
		itemNovoAutor.addActionListener(this);
		menuNovo.add(itemNovoAutor);
		menuNovo.add(itemNovoLivro);
		
		menuVer = new JMenu("Ver");
		barraMenu.add(menuVer);
		
		itemVerLivros = new JMenuItem("Livros");
		itemVerLivros.addActionListener(this);
		
		itemVerAutores = new JMenuItem("Autores");
		itemVerAutores.addActionListener(this);
		menuVer.add(itemVerAutores);
		menuVer.add(itemVerLivros);
		
		menuAlterar = new JMenu("Alterar");
		barraMenu.add(menuAlterar);
		
		itemAlterarAutor = new JMenuItem("Autor");
		itemAlterarAutor.addActionListener(this);
		menuAlterar.add(itemAlterarAutor);
		
		itemAlterarLivro = new JMenuItem("Livro");
		menuAlterar.add(itemAlterarLivro);
		getContentPane().setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		JLabel lblTitulo;
		JPanel panel;
		if (evento.getSource() == itemNovoAutor){
			panel  = new CadastrarAutorPanel(this, null);
			
			lblTitulo = new JLabel("Cadastrar Novo Autor");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
			lblTitulo.setBounds(12, 12, 595, 44);
			lblTitulo.setForeground(new Color(246,245,237));
			panel.add(lblTitulo);
			
			setContentPane(panel);
			validate();
		}else if (evento.getSource() == itemNovoLivro){
			setContentPane(new CadastrarLivroPanel(this,null));
			validate();
		}else if (evento.getSource() == itemVerLivros){
			setContentPane(new VisualizarLivrosPanel(this));
			validate();
		}else if (evento.getSource() == itemVerAutores){
			setContentPane(new VisualizarAutoresPanel(this));
			validate();
		}else if (evento.getSource() == itemAlterarAutor){
			JPanel panelalterarAutor = new VisualizarAutoresPanel(this);
			
			JButton btnAlterarAutor = new JButton("Alterar");
			btnAlterarAutor.setBounds(349, 311, 117, 25);
			btnAlterarAutor.addActionListener(this);
			panelalterarAutor.add(btnAlterarAutor);
			
			lblTitulo = new JLabel("Selecione Autor para Alterar");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setForeground(new Color(246,245,237));
			lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
			lblTitulo.setBounds(12, 24, 595, 44);
			panelalterarAutor.add(lblTitulo);

			setContentPane(panelalterarAutor);
			validate();
		}
	}
}