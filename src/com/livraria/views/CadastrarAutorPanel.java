package com.livraria.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.livraria.controllers.AutorDAO;
import com.livraria.models.Autor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;


public class CadastrarAutorPanel extends JPanel implements ActionListener {

	private JTextField txtNome;
	private JLabel lblNome;
	private JTextField txtCpf;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblCpf;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private AutorDAO autorDAO = new AutorDAO();
	private Autor a = new Autor();
	private JLabel lblCadastrarAutor;

	public CadastrarAutorPanel() {

		setLayout(null);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(104, 67, 45, 15);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(152, 65, 193, 19);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(118, 96, 31, 15);
		add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(152, 94, 193, 19);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(82, 123, 67, 15);
		add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(152, 123, 193, 19);
		add(txtTelefone);
		txtTelefone.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(87, 184, 117, 25);
		btnCadastrar.addActionListener(this);
		add(btnCadastrar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(268, 184, 117, 25);
		add(btnLimpar);
		
		lblCadastrarAutor = DefaultComponentFactory.getInstance().createTitle("Cadastrar Autor");
		lblCadastrarAutor.setFont(new Font("Ubuntu", Font.BOLD, 25));
		lblCadastrarAutor.setBounds(125, 12, 200, 33);
		add(lblCadastrarAutor);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnCadastrar ){
			a.setNome(txtNome.getText());
			a.setCpf(txtCpf.getText());
			a.setTelefone(txtTelefone.getText());
			if( autorDAO.cadastrarAutor(a) )
				JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO no cadastro do Autor!");
		}
		
	}
}