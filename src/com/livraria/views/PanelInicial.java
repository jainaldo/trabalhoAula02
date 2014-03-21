package com.livraria.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class PanelInicial extends JPanel implements ActionListener {

	private JButton btnVerAutores;
	private JButton btnVerLivros;
	private TelaFrame container;
	private JLabel lblVerAutores;
	private JLabel lblVerLivros;
	private JLabel lblTitulo;
	
	public PanelInicial(TelaFrame container) {
		setBackground(new Color(63,73,68));
		setBounds(100, 100, 619, 399);
		this.container = container;
		setLayout(null);

		btnVerAutores = new JButton(new ImageIcon(getClass().getResource("static/autor.png")));
		btnVerAutores.setBounds(164, 106, 99, 98);
		btnVerAutores.addActionListener(this);
		add(btnVerAutores);
		
		btnVerLivros = new JButton(new ImageIcon(getClass().getResource("static/livro.png")));
		btnVerLivros.setBounds(358, 106, 80, 98);
		btnVerLivros.addActionListener(this);
		add(btnVerLivros);
		
		lblVerAutores = new JLabel("Ver  Autores");
		lblVerAutores.setForeground(Color.WHITE);
		lblVerAutores.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblVerAutores.setBounds(173, 205, 90, 23);
		add(lblVerAutores);
		
		lblVerLivros = new JLabel("Ver Livros");
		lblVerLivros.setForeground(new Color(246,245,237));
		lblVerLivros.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblVerLivros.setBounds(366, 207, 72, 19);
		add(lblVerLivros);
		
		lblTitulo = new JLabel("Sistema de Livraria");
		lblTitulo.setForeground(new Color(246,245,237));
		lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 40));
		lblTitulo.setBounds(112, 38, 371, 44);
		add(lblTitulo);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
	
		if (evento.getSource() == btnVerAutores){
			VisualizarAutoresPanel panelVerAutores = new VisualizarAutoresPanel(container);
			setVisible(false);
			container.setContentPane(panelVerAutores);
			container.validate();
		}else if(evento.getSource() == btnVerLivros){
			VisualizarLivrosPanel panelVerLivros = new VisualizarLivrosPanel(container);
			setVisible(false);
			container.setContentPane(panelVerLivros);
			container.validate();
		}
		
	}
}
