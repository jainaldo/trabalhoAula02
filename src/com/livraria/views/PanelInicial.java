package com.livraria.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PanelInicial extends JPanel implements ActionListener {

	private JButton btnVerAutores;
	private JButton btnVerLivros;
	private TelaFrame container;
	private JLabel lblVerAutores;
	private JLabel lblVerLivros;
	
	public PanelInicial(TelaFrame container) {
		this.container = container;
		setLayout(null);

		btnVerAutores = new JButton(new ImageIcon(getClass().getResource("static/autor.png")));
		btnVerAutores.setBounds(173, 106, 80, 98);
		btnVerAutores.addActionListener(this);
		add(btnVerAutores);
		
		btnVerLivros = new JButton(new ImageIcon(getClass().getResource("static/autor.png")));
		btnVerLivros.setBounds(358, 106, 80, 98);
		btnVerLivros.addActionListener(this);
		add(btnVerLivros);
		
		lblVerAutores = new JLabel("Ver  Autores");
		lblVerAutores.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblVerAutores.setBounds(173, 205, 90, 23);
		add(lblVerAutores);
		
		lblVerLivros = new JLabel("Ver Livros");
		lblVerLivros.setFont(new Font("Ubuntu", Font.BOLD, 14));
		lblVerLivros.setBounds(366, 207, 72, 19);
		add(lblVerLivros);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
	
		if (evento.getSource() == btnVerAutores){
			VisualizarAutoresPanel panelVerAutores = new VisualizarAutoresPanel(container);
			setVisible(false);
			container.setContentPane(panelVerAutores);
			container.validate();
		}
		
	}
}
