package FrontEnd;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conector.ClasseConexao;
import Conector.Crud_peca;

//import Conector.Crud_peca;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditarPeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField COD_INPUT;
	private JTextField NOME_INPUT;
	private JTextField PESO_INPUT;
	private JTextField MEDIDA_INPUT;
	private JTextField MARCA_INPUT;
	private JTextField MODELO_INPUT;
	private JTextField ANO_INPUT;
	private JTextField COR_INPUT;
	private JTextField VALOR_INPUT;
	
	Crud_peca peca = new Crud_peca();

	private void ValidaDados() {
//			if(NOME_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO NOME NÃO PODE ESTÁ VAZIO!");
//			}
//			if(PESO_INPUT.getText().isEmpty() ) {
//				JOptionPane.showMessageDialog(null, "O CAMPO PESO NÃO PODE ESTÁ VAZIO!");
//			}
//			if(MEDIDA_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO MEDIDA NÃO PODE ESTÁ VAZIO!");
//			}
//			if(MARCA_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO MARCA NÃO PODE ESTÁ VAZIO!");
//			}
//			if(MODELO_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO MODELO NÃO PODE ESTÁ VAZIO!");
//			}
//			if(ANO_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO ANO NÃO PODE ESTÁ VAZIO!");
//			}
//			if(COR_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO COR NÃO PODE ESTÁ VAZIO!");
//			}
//			if(VALOR_INPUT.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "O CAMPO VALOR NÃO PODE ESTÁ VAZIO!");
//			}
	}

	/**
	 * Create the frame.
	 */
	public EditarPeca() {	
		
		// Config da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 237);
		setTitle("Editar Peça");
		String estIconPath = "src/FrontEnd/images/Pencil.png";
		Image estIcon = Toolkit.getDefaultToolkit().getImage(estIconPath);
		setIconImage(estIcon);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Config dos Botões
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ValidaDados();
				
				// >> CRUD UPDATE
				
				peca.Alterar(Integer.parseInt(COD_INPUT.getText()), NOME_INPUT.getText(), Double.parseDouble(PESO_INPUT.getText()), MEDIDA_INPUT.getText(), MARCA_INPUT.getText(), MODELO_INPUT.getText(), Integer.parseInt(ANO_INPUT.getText()), COR_INPUT.getText(), Double.parseDouble(VALOR_INPUT.getText()));
				NOME_INPUT.setText("");
				PESO_INPUT.setText("");
				MEDIDA_INPUT.setText("");
				MARCA_INPUT.setText("");
				MODELO_INPUT.setText("");
				ANO_INPUT.setText("");
				COR_INPUT.setText("");
				VALOR_INPUT.setText("");
				COD_INPUT.setText("");
				//JOptionPane.showMessageDialog(null, "Peça cadastrada!");
			}
		});
		SALVAR_BTN.setBounds(239, 168, 110, 23);
		contentPane.add(SALVAR_BTN);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(359, 168, 110, 23);
		contentPane.add(CANCELAR_BTN);
		
		JButton DELETAR_BTN = new JButton("DELETAR");
		DELETAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null, "DELETAR ITEM?", "Deletar item", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				System.out.println(escolha);
				if(escolha == 0) {
					// >> CRUD DELETE
					peca.Deletar(Integer.parseInt(COD_INPUT.getText())); //Adicionar a variavel da caixa "IdPeca" usando .getText dentro do "parseInt
					NOME_INPUT.setText("");
					PESO_INPUT.setText("");
					MEDIDA_INPUT.setText("");
					MARCA_INPUT.setText("");
					MODELO_INPUT.setText("");
					ANO_INPUT.setText("");
					COR_INPUT.setText("");
					VALOR_INPUT.setText("");
					COD_INPUT.setText("");	
				}
			}
		});
		DELETAR_BTN.setBounds(10, 168, 89, 23);
		contentPane.add(DELETAR_BTN);
		
		
		// Config dos Labels
		JLabel codLabel = new JLabel("CÓD:");
		codLabel.setBounds(10, 16, 36, 14);
		contentPane.add(codLabel);
		
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 41, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel pesoLabel = new JLabel("PESO:");
		pesoLabel.setBounds(10, 69, 46, 14);
		contentPane.add(pesoLabel);
		
		JLabel medidaLabel = new JLabel("MEDIDA:");
		medidaLabel.setBounds(106, 69, 58, 14);
		contentPane.add(medidaLabel);
		
		JLabel marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(263, 69, 46, 14);
		contentPane.add(marcaLabel);
		
		JLabel modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(10, 97, 67, 14);
		contentPane.add(modeloLabel);
		
		JLabel corLabel = new JLabel("COR:");
		corLabel.setBounds(368, 97, 46, 14);
		contentPane.add(corLabel);
		
		JLabel anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(263, 98, 36, 14);
		contentPane.add(anoLabel);
		
		JLabel valorLabel = new JLabel("VALOR:");
		valorLabel.setBounds(10, 132, 46, 14);
		contentPane.add(valorLabel);
		
		// Config dos Inputs
		
		COD_INPUT = new JTextField();
		COD_INPUT.setBounds(50, 13, 94, 20);
		contentPane.add(COD_INPUT);
		COD_INPUT.setColumns(10);
		COD_INPUT.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume(); // Ignora caracteres não numéricos
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setBounds(50, 38, 419, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		PESO_INPUT = new JTextField();
		PESO_INPUT.setBounds(50, 66, 46, 20);
		contentPane.add(PESO_INPUT);
		PESO_INPUT.setColumns(10);
		PESO_INPUT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)&& c != '.') {
                    e.consume(); // Ignora caracteres não numéricos
                } else if (c == '.') {
                	JTextField source = (JTextField)e.getSource();
                    String text = source.getText();

                    // Se já houver um ponto no texto, não permite um novo ponto
                    if (text.contains(".")) {
                        e.consume();
                    }
                }
            }
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
		
		MEDIDA_INPUT = new JTextField();
		MEDIDA_INPUT.setColumns(10);
		MEDIDA_INPUT.setBounds(174, 66, 67, 20);
		contentPane.add(MEDIDA_INPUT);
		
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(319, 66, 150, 20);
		contentPane.add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(87, 94, 154, 20);
		contentPane.add(MODELO_INPUT);
		
		ANO_INPUT = new JTextField();
		ANO_INPUT.setColumns(10);
		ANO_INPUT.setBounds(298, 94, 60, 20);
		contentPane.add(ANO_INPUT);
		ANO_INPUT.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignora caracteres não numéricos
                }
            }
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
		
		COR_INPUT = new JTextField();
		COR_INPUT.setColumns(10);
		COR_INPUT.setBounds(401, 94, 68, 20);
		contentPane.add(COR_INPUT);
		
		VALOR_INPUT = new JTextField();
		VALOR_INPUT.setColumns(10);
		VALOR_INPUT.setBounds(55, 129, 89, 20);
		contentPane.add(VALOR_INPUT);
		
		JButton CONSULTAR_BTN = new JButton("CONSULTAR");
		CONSULTAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Consultar(Integer.parseInt(COD_INPUT.getText()));
			}
		});
		CONSULTAR_BTN.setBounds(119, 168, 110, 23);
		contentPane.add(CONSULTAR_BTN);
		VALOR_INPUT.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume(); // Ignora caracteres não numéricos
				} else if (c == '.') {
					JTextField source = (JTextField)e.getSource();
					String text = source.getText();
					
					// Se já houver um ponto no texto, não permite um novo ponto
					if (text.contains(".")) {
						e.consume();
					}
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// NÃO UTILIZADO
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// NÃO UTILIZADO
			}
		});
	}	



private ResultSet Consultar(int IdPeca) {
    Connection conexao = null;
    PreparedStatement comando = null;
    ResultSet resultado = null;

    try {
        conexao = ClasseConexao.Conectar();
        String sql = "SELECT * FROM peca WHERE IdPeca=?";
        comando = conexao.prepareStatement(sql);
        comando.setInt(1, IdPeca);
        resultado = comando.executeQuery();
        if (resultado.next()) {
        	NOME_INPUT.setText(resultado.getString(2));
        	PESO_INPUT.setText(resultado.getString(4));
        	MEDIDA_INPUT.setText(resultado.getString(5));
        	MARCA_INPUT.setText(resultado.getString(6));
        	MODELO_INPUT.setText(resultado.getString(7));
        	ANO_INPUT.setText(resultado.getString(8));
        	COR_INPUT.setText(resultado.getString(9));
        	VALOR_INPUT.setText(resultado.getString(10));
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