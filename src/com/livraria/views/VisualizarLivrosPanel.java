package com.livraria.views;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;

import com.livraria.controllers.LivroDAO;
import com.livraria.models.Livro;

public class VisualizarLivrosPanel extends JPanel implements ActionListener {
	private JList listaLivros;
	private LivroDAO livroDAO;
	private Vector<Livro> todosLivros;
	private JButton btnVoltar;
	private JButton btnApagarLivro;
	private JButton btnAlterarLivro;
	private TelaFrame container;
	private JLabel lblHelptext;
	private JLabel lblTitulo;
	
	public VisualizarLivrosPanel(TelaFrame container) {
		this.container =container;
		setLayout(null);
		
		livroDAO = new LivroDAO();
		todosLivros = livroDAO.getTodosLivros();
		
		listaLivros = new JList(todosLivros);
		listaLivros.setBorder(new MatteBorder(10, 2, 2, 2, (Color) new Color(13, 132, 200)));
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setBounds(41, 71, 537, 202);
		add(listaLivros);
		
		btnAlterarLivro = new JButton("Alterar");
		btnAlterarLivro.setBounds(253, 311, 117, 25);
		btnAlterarLivro.addActionListener(this);
		add(btnAlterarLivro);
		
		btnApagarLivro = new JButton("Apagar");
		btnApagarLivro.setBounds(417, 311, 108, 25);
		btnApagarLivro.addActionListener(this);
		add(btnApagarLivro);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(89, 311, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblHelptext = new JLabel("*Selecione o Livro da Lista para Alterar ou Apagar!");
		lblHelptext.setFont(new Font("Ubuntu", Font.BOLD, 13));
		lblHelptext.setForeground(new Color(0, 0, 128));
		lblHelptext.setBackground(Color.LIGHT_GRAY);
		lblHelptext.setBounds(41, 272, 376, 15);
		add(lblHelptext);
		
		lblTitulo = new JLabel("Livros Cadastrados");
		lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
		lblTitulo.setBounds(126, 12, 353, 44);
		add(lblTitulo);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			setVisible(false);
			container.setContentPane(panelinicial);
			container.validate();
		}else if (evento.getSource() == btnAlterarLivro){
			Livro l = todosLivros.get(listaLivros.getSelectedIndex());
			CadastrarLivroPanel panelLivro = new CadastrarLivroPanel(container,l);
			setVisible(false);
			container.setContentPane(panelLivro);
			container.validate();
		}else if(evento.getSource() == btnApagarLivro){
			int opcao = JOptionPane.showConfirmDialog(null, 
					"Tem certeza que deseja apagar o Livro selecionado?", "Exclusão de Livro",
					JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
            	Livro l = todosLivros.get( listaLivros.getSelectedIndex() );
            	if( livroDAO.apagarLivro(l.getId() ) ) {
            		JOptionPane.showMessageDialog(null, "Livro Apagado com Sucesso!");            		
            		todosLivros = livroDAO.getTodosLivros();
        			listaLivros.setListData(todosLivros);
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão!");
            	}
            }
		}
	}

}
