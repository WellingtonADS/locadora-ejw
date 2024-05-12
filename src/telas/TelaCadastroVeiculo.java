package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField modeloTextField;
    private JTextField marcaTextField;
    private JTextField anoTextField;
    private JTextField valorTextField;
    private cadastro.CadastroVeiculo cadastroVeiculo;

    public TelaCadastroVeiculo() {
        cadastroVeiculo = new cadastro.CadastroVeiculo(); // Inicializa a instância de CadastroVeiculo

        setTitle("Cadastro de Veículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2));

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloTextField = new JTextField();
        mainPanel.add(modeloLabel);
        mainPanel.add(modeloTextField);

        JLabel marcaLabel = new JLabel("Marca:");
        marcaTextField = new JTextField();
        mainPanel.add(marcaLabel);
        mainPanel.add(marcaTextField);

        JLabel anoLabel = new JLabel("Ano:");
        anoTextField = new JTextField();
        mainPanel.add(anoLabel);
        mainPanel.add(anoTextField);

        JLabel valorLabel = new JLabel("Valor da Diária:");
        valorTextField = new JTextField();
        mainPanel.add(valorLabel);
        mainPanel.add(valorTextField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarVeiculo();
            }
        });
        mainPanel.add(cadastrarButton);
        
        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
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
        mainPanel.add(voltarButton);

        add(mainPanel);
        setVisible(true);
    }

    private void cadastrarVeiculo() {
        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano = Integer.parseInt(anoTextField.getText());
        double valorDiaria = Double.parseDouble(valorTextField.getText());

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chama o método de cadastro da classe CadastroVeiculo
        cadastroVeiculo.cadastrarVeiculo(modelo, marca, ano, valorDiaria);

        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroVeiculo();
            }
        });
    }
}
