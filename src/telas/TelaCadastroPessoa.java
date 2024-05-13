package telas;

import javax.swing.*;
import cadastro.CadastroPessoa; // Add the missing import statement for CadastroPessoa
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
        mainPanel.setLayout(new GridLayout(5, 2, 0, 6));
        
        // Define a margem interna da tela principal
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
                cadastrarPessoa(); // Chama o método cadastrarPessoa da classe TelaCadastroPessoa
            }
        });
        mainPanel.add(cadastrarButton);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(font);
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
