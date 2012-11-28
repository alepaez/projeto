package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.AreaAtuacaoRemote;

import models.AreaAtuacao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarAreaAtuacao extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private AreaAtuacao areaAtuacao;

	/**
	 * Create the frame.
	 */
	public EditarAreaAtuacao(AreaAtuacao aa) {
		areaAtuacao = aa;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setText(areaAtuacao.getNome());
		JLabel lblNome = new JLabel("Nome");
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InitialContext ic = new InitialContext();
					AreaAtuacaoRemote aaDao = (AreaAtuacaoRemote)ic.lookup("java:global/curriculoEAR/curriculo/AreaAtuacaoDao");
					areaAtuacao.setNome(nome.getText());
					aaDao.update(areaAtuacao);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				new AreasAtuacao().setVisible(true);
			}
		});
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AreasAtuacao().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addGap(18)
							.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnCancelar))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}