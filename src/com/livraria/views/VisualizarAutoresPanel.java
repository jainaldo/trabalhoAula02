package com.livraria.views;

import javax.swing.JPanel;
import javax.swing.JTable;

public class VisualizarAutoresPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VisualizarAutoresPanel() {
		setLayout(null);
		
		table = new JTable();
		table.setBounds(33, 41, 371, 218);
		
		add(table);

	}
}
