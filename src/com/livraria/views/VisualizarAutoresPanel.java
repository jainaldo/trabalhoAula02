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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;


public class VisualizarAutoresPanel extends JPanel implements ActionListener {

	private JList listaAutores;
	private AutorDAO autorDAO;
	private Vector<Autor> todosAutores;
	private JButton btnVoltar;
	private JButton btnApagarAutor;
	private JButton btnAlterarAutor;
	private TelaFrame container;
	private JLabel lblHelptext;
	private JLabel lblTitulo;



	public VisualizarAutoresPanel(TelaFrame container ) {
		this.container =container;
		setBackground(new Color(63,73,68));
		setBounds(100, 100, 619, 399);
		setLayout(null);

		
		autorDAO = new AutorDAO();
		todosAutores = autorDAO.getTodosAutores();
		
		listaAutores = new JList(todosAutores);
		listaAutores.setBackground(new Color(246,245,237));
		listaAutores.setBorder(new MatteBorder(10, 2, 2, 2, (Color) new Color(13, 132, 200)));
		listaAutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaAutores.setBounds(51, 80, 514, 189);
		add(listaAutores);
		
		btnAlterarAutor = new JButton("Alterar");
		btnAlterarAutor.setBounds(349, 311, 117, 25);
		btnAlterarAutor.addActionListener(this);
		add(btnAlterarAutor);
		
//		btnApagarAutor = new JButton("Apagar");
//		btnApagarAutor.setBounds(417, 311, 108, 25);
//		btnApagarAutor.addActionListener(this);
//		add(btnApagarAutor);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(161, 311, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblHelptext = new JLabel("*Selecione um Autor da Lista para Alterar ou Apagar!");
		lblHelptext.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblHelptext.setForeground(new Color(246,245,237));
		lblHelptext.setBounds(47, 273, 376, 15);
		add(lblHelptext);
//		
//		lblTitulo = new JLabel("Autores Cadastrados");
//		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//		lblTitulo.setForeground(new Color(246,245,237));
//		lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
//		lblTitulo.setBounds(12, 24, 595, 44);
//		add(lblTitulo);
		
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			setVisible(false);
			container.setContentPane(panelinicial);
			container.validate();			
		}else if (evento.getSource() == btnAlterarAutor){
			Autor a = todosAutores.get(listaAutores.getSelectedIndex());
			CadastrarAutorPanel panelAutor = new CadastrarAutorPanel(container,a);
			
			JLabel lblTitulo = new JLabel("Alterar Autor");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
			lblTitulo.setBounds(12, 12, 595, 44);
			lblTitulo.setForeground(new Color(246,245,237));
			
			panelAutor.add(lblTitulo);
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
