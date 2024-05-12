package telas;

import javax.swing.*;
import cadastro.CadastroPessoa;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroPessoa extends JFrame {
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField telefoneTextField;
    private CadastroPessoa cadastroPessoa; // Instância da classe CadastroPessoa

    public TelaCadastroPessoa() {
        // Inicializa a instância de CadastroPessoa
        cadastroPessoa = new CadastroPessoa();

        setTitle("Cadastro de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        nomeTextField = new JTextField();
        mainPanel.add(nomeLabel);
        mainPanel.add(nomeTextField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoTextField = new JTextField();
        mainPanel.add(enderecoLabel);
        mainPanel.add(enderecoTextField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneTextField = new JTextField();
        mainPanel.add(telefoneLabel);
        mainPanel.add(telefoneTextField);

       

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPessoa(); // Chama o método cadastrarPessoa da classe TelaCadastroPessoa
            }
        });
        mainPanel.add(cadastrarButton);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Oculta a tela atual
                setVisible(false);
                // Libera os recursos da tela atual
                dispose();
                // Cria uma instância da tela principal e a torna visível
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

        // Verifica se todos os campos obrigatórios estão preenchidos
        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Não realiza o cadastro se algum campo estiver vazio
        }

        // Chama o método de cadastro da classe CadastroPessoa
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
