package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cadastro.CadastroCliente;

/**
 * Classe responsável por exibir a tela de cadastro de cliente.
 */
public class TelaCadastroCliente extends JFrame {

    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField telefoneTextField;
    private JRadioButton pessoaFisicaRadioButton;
    private JRadioButton pessoaJuridicaRadioButton;
    private ButtonGroup tipoPessoaButtonGroup;
    private CadastroCliente cadastroCliente;

    public TelaCadastroCliente() {
        cadastroCliente = new CadastroCliente(); // Assuming CadastroCliente handles PJ/PF logic

        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 0, 6));

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

        // Radio Button Group for type selection
        tipoPessoaButtonGroup = new ButtonGroup();

        pessoaFisicaRadioButton = new JRadioButton("Pessoa Física");
        pessoaFisicaRadioButton.setFont(font);
        tipoPessoaButtonGroup.add(pessoaFisicaRadioButton);
        mainPanel.add(pessoaFisicaRadioButton);

        pessoaJuridicaRadioButton = new JRadioButton("Pessoa Jurídica");
        pessoaJuridicaRadioButton.setFont(font);
        tipoPessoaButtonGroup.add(pessoaJuridicaRadioButton);
        mainPanel.add(pessoaJuridicaRadioButton);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(font);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
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

    private void cadastrarCliente() {
        String nome = nomeTextField.getText();
        String endereco = enderecoTextField.getText();
        String telefone = telefoneTextField.getText();
        String tipoPessoa = null; // Initialize

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (pessoaFisicaRadioButton.isSelected()) {
            tipoPessoa = "PF"; // Assign "PF" for Pessoa Física
        } else if (pessoaJuridicaRadioButton.isSelected()) {
            tipoPessoa = "PJ"; // Assign "PJ" for Pessoa Jurídica
        }

        // Validation (optional)
        if (tipoPessoa == null) {
            JOptionPane.showMessageDialog(this, "Selecione o tipo de pessoa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroCliente.cadastrarCliente(nome, endereco, telefone, tipoPessoa); // Pass typePessoa to CadastroCliente

        JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroCliente();
            }
        });
    }
}
