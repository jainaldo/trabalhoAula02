package com.livraria.views;


import java.util.Vector;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.livraria.controllers.AutorDAO;
import com.livraria.models.Autor;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VisualizarAutoresPanel extends JPanel implements ActionListener {

	private JList listaAutores;
	private AutorDAO autorDAO;
	private Vector<Autor> todosAutores;
	private JButton btnVoltar;
	private JButton btnApagarAutor;
	private JButton btnAlterarAutor;
	private TelaFrame container;



	public VisualizarAutoresPanel(TelaFrame container ) {
		this.container =container;
		setForeground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 619, 399);
		
		AutorDAO autorDAO = new AutorDAO();
		todosAutores = autorDAO.getTodosAutores();
		
		listaAutores = new JList(todosAutores);
		listaAutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaAutores.setBounds(91, 45, 434, 224);
		add(listaAutores);
		
		btnAlterarAutor = new JButton("Alterar");
		btnAlterarAutor.setBounds(253, 311, 117, 25);
		btnAlterarAutor.addActionListener(this);
		add(btnAlterarAutor);
		
		btnApagarAutor = new JButton("Apagar");
		btnApagarAutor.setBounds(417, 311, 108, 25);
		add(btnApagarAutor);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(89, 311, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnVoltar){
			setVisible(false);
			validate();			
		}else if (evento.getSource() == btnAlterarAutor){
			Autor a = todosAutores.get(listaAutores.getSelectedIndex());
			CadastrarAutorPanel tela = new CadastrarAutorPanel(container,a);
			setVisible(false);
			container.setContentPane(tela);
		}
		
	}
}
