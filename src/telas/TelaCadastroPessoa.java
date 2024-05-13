package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cadastro.CadastroPessoa;

/**
 * Classe responsável por exibir a tela de cadastro de pessoa.
 */
public class TelaCadastroPessoa extends JFrame {
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField telefoneTextField;
    private CadastroPessoa cadastroPessoa;

    public TelaCadastroPessoa() {
        cadastroPessoa = new CadastroPessoa();

        setTitle("Cadastro de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 0, 6));
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(font);
        nomeTextField = new JTextField();
        nomeTextField.setFont(font);
        mainPanel.add(nomeLabel);
        mainPanel.add(nomeTextField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setFont(font);
        enderecoTextField = new JTextField();
        enderecoTextField.setFont(font);
        mainPanel.add(enderecoLabel);
        mainPanel.add(enderecoTextField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(font);
        telefoneTextField = new JTextField();
        telefoneTextField.setFont(font);
        mainPanel.add(telefoneLabel);
        mainPanel.add(telefoneTextField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(font);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPessoa();
            }
        });
        mainPanel.add(cadastrarButton);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(font);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            }
        });
        mainPanel.add(btnVoltar);

        add(mainPanel);
        setVisible(true);
    }

    private void cadastrarPessoa() {
        String nome = nomeTextField.getText();
        String endereco = enderecoTextField.getText();
        String telefone = telefoneTextField.getText();

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroPessoa.cadastrarPessoa(nome, endereco, telefone);

        JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroPessoa();
            }
        });
    }
}
