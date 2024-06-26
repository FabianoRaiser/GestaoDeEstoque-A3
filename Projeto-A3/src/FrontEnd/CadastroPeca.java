package FrontEnd;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conector.Crud_peca;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroPeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NOME_INPUT;
	private JTextField PESO_INPUT;
	private JTextField MEDIDA_INPUT;
	private JTextField MARCA_INPUT;
	private JTextField MODELO_INPUT;
	private JTextField ANO_INPUT;
	private JTextField COR_INPUT;
	private JTextField VALOR_INPUT;

	private boolean ValidaDados() {
		boolean validado = true;
			if(NOME_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO NOME NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(PESO_INPUT.getText().isEmpty() ) {
				JOptionPane.showMessageDialog(null, "O CAMPO PESO NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(MEDIDA_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO MEDIDA NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(MARCA_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO MARCA NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(MODELO_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO MODELO NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(ANO_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO ANO NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(COR_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO COR NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
			if(VALOR_INPUT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O CAMPO VALOR NÃO PODE ESTÁ VAZIO!");
				validado = false;
			}
		
		return validado;
	}

	/**
	 * Create the frame.
	 */
	public CadastroPeca() {	
		
		// Config da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 224);
		setTitle("Novo Cadastro de Peça");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Config dos Botões
		JButton SALVAR_BTN = new JButton("SALVAR");
		SALVAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ValidaDados()) 
				{
					// >> CRUD INSERT
					Crud_peca Inserir_peca = new Crud_peca();
					Inserir_peca.Inserir(NOME_INPUT.getText(),Double.parseDouble(PESO_INPUT.getText()), MEDIDA_INPUT.getText(), MARCA_INPUT.getText(), MODELO_INPUT.getText(),Integer.parseInt(ANO_INPUT.getText()),COR_INPUT.getText(),Double.parseDouble(VALOR_INPUT.getText()));
					NOME_INPUT.setText("");
					PESO_INPUT.setText("");
					MEDIDA_INPUT.setText("");
					MARCA_INPUT.setText("");
					MODELO_INPUT.setText("");
					ANO_INPUT.setText("");
					COR_INPUT.setText("");
					VALOR_INPUT.setText("");
					
				} else {
					JOptionPane.showMessageDialog(null, "Peça NÃO registrada", "Erro!" , JOptionPane.ERROR_MESSAGE);
				}
				
				NOME_INPUT.setText("");
				PESO_INPUT.setText("");
				MEDIDA_INPUT.setText("");
				MARCA_INPUT.setText("");
				MODELO_INPUT.setText("");
				ANO_INPUT.setText("");
				COR_INPUT.setText("");
				VALOR_INPUT.setText("");
			}
		});
		SALVAR_BTN.setBounds(239, 149, 110, 23);
		contentPane.add(SALVAR_BTN);
		
		JButton CANCELAR_BTN = new JButton("CANCELAR");
		CANCELAR_BTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		CANCELAR_BTN.setBounds(359, 149, 110, 23);
		contentPane.add(CANCELAR_BTN);
		
		
		// Config dos Labels
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setBounds(10, 22, 46, 14);
		contentPane.add(nomeLabel);
		
		JLabel pesoLabel = new JLabel("PESO:");
		pesoLabel.setBounds(10, 50, 46, 14);
		contentPane.add(pesoLabel);
		
		JLabel medidaLabel = new JLabel("MEDIDA:");
		medidaLabel.setBounds(106, 50, 58, 14);
		contentPane.add(medidaLabel);
		
		JLabel marcaLabel = new JLabel("MARCA:");
		marcaLabel.setBounds(263, 50, 46, 14);
		contentPane.add(marcaLabel);
		
		JLabel modeloLabel = new JLabel("MODELO:");
		modeloLabel.setBounds(10, 78, 67, 14);
		contentPane.add(modeloLabel);
		
		JLabel corLabel = new JLabel("COR:");
		corLabel.setBounds(368, 78, 46, 14);
		contentPane.add(corLabel);
		
		JLabel anoLabel = new JLabel("ANO:");
		anoLabel.setBounds(263, 79, 36, 14);
		contentPane.add(anoLabel);
		
		JLabel valorLabel = new JLabel("VALOR:");
		valorLabel.setBounds(10, 113, 46, 14);
		contentPane.add(valorLabel);
		
		// Config dos Inputs
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setBounds(50, 19, 419, 20);
		contentPane.add(NOME_INPUT);
		NOME_INPUT.setColumns(10);
		
		PESO_INPUT = new JTextField();
		PESO_INPUT.setBounds(50, 47, 46, 20);
		contentPane.add(PESO_INPUT);
		PESO_INPUT.setColumns(10);
		PESO_INPUT.addKeyListener(new KeyListener() {
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
		
		MEDIDA_INPUT = new JTextField();
		MEDIDA_INPUT.setColumns(10);
		MEDIDA_INPUT.setBounds(174, 47, 67, 20);
		contentPane.add(MEDIDA_INPUT);
		
		MARCA_INPUT = new JTextField();
		MARCA_INPUT.setColumns(10);
		MARCA_INPUT.setBounds(319, 47, 150, 20);
		contentPane.add(MARCA_INPUT);
		
		MODELO_INPUT = new JTextField();
		MODELO_INPUT.setColumns(10);
		MODELO_INPUT.setBounds(87, 75, 154, 20);
		contentPane.add(MODELO_INPUT);
		
		ANO_INPUT = new JTextField();
		ANO_INPUT.setColumns(10);
		ANO_INPUT.setBounds(298, 75, 60, 20);
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
		COR_INPUT.setBounds(401, 75, 68, 20);
		contentPane.add(COR_INPUT);
		
		VALOR_INPUT = new JTextField();
		VALOR_INPUT.setColumns(10);
		VALOR_INPUT.setBounds(55, 110, 89, 20);
		contentPane.add(VALOR_INPUT);
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
}
