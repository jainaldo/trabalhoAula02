package com.livraria.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.livraria.controllers.LivroDAO;
import com.livraria.models.Livro;

public class VisualizarLivrosPanel extends JPanel implements ActionListener {
	private JList listaLivros;
	private LivroDAO livroDAO;
	private Vector<Livro> todosLivros;
	private JButton btnVoltar;
	private JButton btnApagarAutor;
	private JButton btnAlterarAutor;
	private TelaFrame container;
	private JLabel lblHelptext;
	
	public VisualizarLivrosPanel(TelaFrame container) {
		this.container =container;
		setLayout(null);
		
		livroDAO = new LivroDAO();
		todosLivros = livroDAO.getTodosLivros();
		
		listaLivros = new JList(todosLivros);
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setBounds(91, 45, 434, 224);
		add(listaLivros);
		
		btnAlterarAutor = new JButton("Alterar");
		btnAlterarAutor.setBounds(253, 311, 117, 25);
		btnAlterarAutor.addActionListener(this);
		add(btnAlterarAutor);
		
		btnApagarAutor = new JButton("Apagar");
		btnApagarAutor.setBounds(417, 311, 108, 25);
		btnApagarAutor.addActionListener(this);
		add(btnApagarAutor);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(89, 311, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblHelptext = new JLabel("*Selecione um Autor da Lista para Alterar ou Apagar!");
		lblHelptext.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblHelptext.setForeground(new Color(0, 0, 128));
		lblHelptext.setBackground(Color.LIGHT_GRAY);
		lblHelptext.setBounds(91, 271, 376, 15);
		add(lblHelptext);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
