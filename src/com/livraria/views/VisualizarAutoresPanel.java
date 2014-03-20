package com.livraria.views;



import java.util.Vector;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import com.livraria.controllers.AutorDAO;
import com.livraria.models.Autor;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;


public class VisualizarAutoresPanel extends JPanel implements ActionListener {

	private JList listaAutores;
	private AutorDAO autorDAO;
	private Vector<Autor> todosAutores;
	private JButton btnVoltar;
	private JButton btnApagarAutor;
	private JButton btnAlterarAutor;
	private TelaFrame container;
	private JLabel lblHelptext;



	public VisualizarAutoresPanel(TelaFrame container ) {
		this.container =container;
		setForeground(Color.WHITE);
		setLayout(null);
		setBounds(100, 100, 619, 399);
		
		autorDAO = new AutorDAO();
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
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			setVisible(false);
			container.setContentPane(panelinicial);
			validate();			
		}else if (evento.getSource() == btnAlterarAutor){
			Autor a = todosAutores.get(listaAutores.getSelectedIndex());
			CadastrarAutorPanel panelAutor = new CadastrarAutorPanel(container,a);
			setVisible(false);
			container.setContentPane(panelAutor);
			container.validate();	
		}else if(evento.getSource() == btnApagarAutor){
			int opcao = JOptionPane.showConfirmDialog(null, 
					"Tem certeza que deseja apagar o Autor selecionado?", "Exclusão de Autor",
					JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
            	Autor a = todosAutores.get( listaAutores.getSelectedIndex() );
            	if( autorDAO.apagarAutor(a.getId() ) ) {
            		JOptionPane.showMessageDialog(null, "Autor Apagado com Sucesso!");            		
            		todosAutores = autorDAO.getTodosAutores();
        			listaAutores.setListData(todosAutores);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão!");
            	}
            }
		}
	}
}
