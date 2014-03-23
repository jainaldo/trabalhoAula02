package com.livraria.views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;


public class TelaFrame extends JFrame  implements ActionListener {
	private JMenuBar barraMenu;
	private JMenu menuNovo;
	private JMenuItem itemNovoLivro;
	private JMenuItem itemNovoAutor;

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
		getContentPane().setLayout(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		JLabel titulo;
		if (evento.getSource() == itemNovoAutor){
			CadastrarAutorPanel panelAutor = new CadastrarAutorPanel(this,null);
			
			titulo = new JLabel("Cadastrar Novo Autor");
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
			titulo.setBounds(12, 12, 595, 44);
			titulo.setForeground(new Color(246,245,237));
			panelAutor.add(titulo);
			
			setContentPane(panelAutor);
			validate();	
			
		}else if (evento.getSource() == itemNovoLivro){
			CadastrarLivroPanel panelLivro = new CadastrarLivroPanel(this,null);
			
			titulo = new JLabel("Cadastrar Novo Livro");
			titulo.setHorizontalAlignment(SwingConstants.CENTER);
			titulo.setForeground(new Color(246,245,237));
			titulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
			titulo.setBounds(12, 12, 595, 44);
			panelLivro.add(titulo);
			setContentPane(panelLivro);
			validate();
		}
		
	}
}