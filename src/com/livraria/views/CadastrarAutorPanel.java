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
import java.awt.Font;


public class CadastrarAutorPanel extends JPanel implements ActionListener {

	private JTextField txtNome;
	private JLabel lblNome;
	private JTextField txtCpf;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblCpf;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private AutorDAO autorDAO = new AutorDAO();
	private Autor a;
	private JButton btnAlterar;
	private TelaFrame container;
	private JLabel lblTitulo;

	public CadastrarAutorPanel(TelaFrame container,Autor a) {
		this.container = container;
		this.a = a;
		setLayout(null);
		setBounds(100, 100, 619, 398);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(174, 83, 45, 15);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(222, 81, 193, 19);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(188, 126, 31, 15);
		add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(222, 124, 193, 19);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(152, 162, 67, 15);
		add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(222, 162, 193, 19);
		add(txtTelefone);
		txtTelefone.setColumns(10);
				
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(321, 220, 117, 25);
		btnVoltar.addActionListener(this);
		add(btnVoltar);
		
		lblTitulo = new JLabel("Cadastrar Novo Autor");
		lblTitulo.setFont(new Font("Ubuntu", Font.BOLD, 38));
		lblTitulo.setBounds(105, 12, 422, 44);
		add(lblTitulo);
				
		if(a == null) {
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setBounds(153, 220, 117, 25);
			btnCadastrar.addActionListener(this);
			add(btnCadastrar);
					
		}
		else {
			btnAlterar = new JButton("Alterar");
			btnAlterar.setBounds(153, 220, 117, 25);
			btnAlterar.addActionListener(this);
			add(btnAlterar);
			
			txtNome.setText(a.getNome() );
			txtCpf.setText(a.getCpf() );
			txtTelefone.setText(a.getTelefone());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == btnCadastrar ){
			a = new Autor();
			a.setNome(txtNome.getText());
			a.setCpf(txtCpf.getText());
			a.setTelefone(txtTelefone.getText());
			if( autorDAO.cadastrarAutor(a) ){
				JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso");
				VisualizarAutoresPanel panelVerAutores = new VisualizarAutoresPanel(container);
				setVisible(false);
				container.setContentPane(panelVerAutores);
				container.validate();
			}else
				JOptionPane.showMessageDialog(null, "ERRO no cadastro do Autor!");
		}else if( evento.getSource() == btnAlterar){
			a.setNome( txtNome.getText() );
			a.setCpf( txtCpf.getText());
			a.setTelefone(txtTelefone.getText() );
			
			if( autorDAO.atualizarAutor(a) ){
				JOptionPane.showMessageDialog(null, "Autor atualizado com sucesso!");
				VisualizarAutoresPanel panelVerAutores = new VisualizarAutoresPanel(container);
				setVisible(false);
				container.setContentPane(panelVerAutores);
				container.validate();
			}else
				JOptionPane.showMessageDialog(null, "ERRO na atualização do Autor!");			
			
		}else if(evento.getSource() == btnVoltar){
			PanelInicial panelinicial = new PanelInicial(container);
			setVisible(false);
			container.setContentPane(panelinicial);
			container.validate();	
		}
		
	}
}