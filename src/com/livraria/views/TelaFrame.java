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
	private JMenu menuNovo;
	private JMenuItem itemNovoLivro;
	private JMenuItem itemNovoAutor;
	private JMenu menuVer;
	private JMenu menuExluir;
	private JMenuItem itemExluirAutor;
	private JMenuItem itemExluirLivros;
	private JMenuItem itemVerLivros;

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
		menuNovo.add(itemNovoLivro);
		
		itemNovoAutor = new JMenuItem("Autor");
		itemNovoAutor.addActionListener(this);
		menuNovo.add(itemNovoAutor);
		
		menuVer = new JMenu("Ver");
		barraMenu.add(menuVer);
		
		itemVerLivros = new JMenuItem("Livros");
		menuVer.add(itemVerLivros);
		
		JMenuItem itemVerAutores = new JMenuItem("Autores");
		menuVer.add(itemVerAutores);
		
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
		if (evento.getSource() == itemNovoAutor){
			setContentPane(new CadastrarAutorPanel(this,null));
			validate();
		}else if (evento.getSource() == itemNovoLivro){
			setContentPane(new CadastrarLivroPanel(this,null));
			validate();
		}
		
	}
}