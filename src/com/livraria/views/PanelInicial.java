package com.livraria.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInicial extends JPanel implements ActionListener {

	private JButton btnVerAutores;
	private TelaFrame container;
	
	public PanelInicial(TelaFrame container) {
		this.container = container;
		setLayout(null);
		btnVerAutores = new JButton(new ImageIcon(getClass().getResource("static/autor.png")));
		btnVerAutores.setBounds(134, 87, 80, 98);
		btnVerAutores.addActionListener(this);
		add(btnVerAutores);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
	
		if (evento.getSource() == btnVerAutores){
			VisualizarAutoresPanel panelVerAutores = new VisualizarAutoresPanel(container);
			setVisible(false);
			container.setContentPane(panelVerAutores);
			validate();
		}
		
	}

}
