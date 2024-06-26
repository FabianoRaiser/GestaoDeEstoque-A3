package FrontEnd;


import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conector.ClasseConexao;
import Conector.Crud_cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField COD_INPUT;
	private JTextField NOME_INPUT;
	private JTextField ENDERECO_INPUT;
	private JTextField TELEFONE_INPUT;
	
	Crud_cliente cliente = new Crud_cliente();


	/**
	 * Create the frame.
	 */
	public EditarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Editar Cliente");
		String estIconPath = "src/FrontEnd/images/Pencil.png";
		Image estIcon = Toolkit.getDefaultToolkit().getImage(estIconPath);
		setBounds(100, 100, 450, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel codLabel = new JLabel("CÓD:");
		codLabel.setBounds(10, 11, 46, 14);
		contentPane.add(codLabel);
		
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 36, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel enderecoLabel = new JLabel("ENDEREÇO:");
		enderecoLabel.setBounds(10, 61, 68, 14);
		contentPane.add(enderecoLabel);
		
		JLabel telefoneLabel = new JLabel("TELEFONE:");
		telefoneLabel.setBounds(10, 86, 68, 14);
		contentPane.add(telefoneLabel);
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(66, 8, 86, 20);
		contentPane.add(COD_INPUT);
		COD_INPUT.setColumns(10);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 33, 358, 20);
		contentPane.add(NOME_INPUT);
		
		ENDERECO_INPUT = new JTextField();
		ENDERECO_INPUT.setColumns(10);
		ENDERECO_INPUT.setBounds(76, 58, 348, 20);
		contentPane.add(ENDERECO_INPUT);
		
		TELEFONE_INPUT = new JTextField();
		TELEFONE_INPUT.setColumns(10);
		TELEFONE_INPUT.setBounds(76, 83, 175, 20);
		contentPane.add(TELEFONE_INPUT);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(314, 114, 110, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer.parseInt(COD_INPUT.getText());
		        if (NOME_INPUT.getText().isEmpty()) {
				} else {
					NOME_INPUT.getText();
				}
		        if (ENDERECO_INPUT.getText().isEmpty()) {
				} else {
					ENDERECO_INPUT.getText();
				}
		        if (TELEFONE_INPUT.getText().isEmpty()) {
				} else {
					TELEFONE_INPUT.getText();
				}
				
				cliente.Alterar(Integer.parseInt(COD_INPUT.getText()), NOME_INPUT.getText(), TELEFONE_INPUT.getText(), ENDERECO_INPUT.getText());
				NOME_INPUT.setText("");
				TELEFONE_INPUT.setText("");
				ENDERECO_INPUT.setText("");
				COD_INPUT.setText("");
			}
		});
		SALVAR_BTN.setBounds(193, 114, 110, 23);
		contentPane.add(SALVAR_BTN);
		
		JButton DELETAR_BTN = new JButton("DELETAR");
		DELETAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null, "DELETAR ITEM?", "Deletar item", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				System.out.println(escolha);
				if(escolha == 0) {
					
					// >> CRUD DELETE
					
					
					Crud_cliente Deletar_cliente = new Crud_cliente();
					Deletar_cliente.Deletar(Integer.parseInt(COD_INPUT.getText()));
					NOME_INPUT.setText("");
					TELEFONE_INPUT.setText("");
					ENDERECO_INPUT.setText("");
					COD_INPUT.setText("");		
				}
			}
		});
		DELETAR_BTN.setBounds(10, 114, 110, 23);
		contentPane.add(DELETAR_BTN);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar(Integer.parseInt(COD_INPUT.getText()));
			}
		});
		btnNewButton.setBounds(162, 7, 103, 23);
		contentPane.add(btnNewButton);
	}
	private ResultSet Consultar(int IdCliente) {
	    Connection conexao = null;
	    PreparedStatement comando = null;
	    ResultSet resultado = null;

	    try {
	        conexao = ClasseConexao.Conectar();
	        String sql = "SELECT * FROM cliente WHERE IdCliente=?";
	        comando = conexao.prepareStatement(sql);
	        comando.setInt(1, IdCliente);
	        resultado = comando.executeQuery();
	        if (resultado.next()) {
	        	NOME_INPUT.setText(resultado.getString(2));
	        	TELEFONE_INPUT.setText(resultado.getString(3));
	        	ENDERECO_INPUT.setText(resultado.getString(4));
			} else {

			}

	        return resultado;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;

	    } finally {
	        ClasseConexao.FecharConexao(conexao);
	        try {
	            if (comando != null) {
	                comando.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  }
	}
