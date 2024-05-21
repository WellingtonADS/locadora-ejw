package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cadastro.CadastroVeiculo;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField modeloTextField;
    private JTextField marcaTextField;
    private JTextField anoTextField;
    private JTextField valorTextField;
    private CadastroVeiculo cadastroVeiculo;
    

    public TelaCadastroVeiculo() {
        cadastroVeiculo = new CadastroVeiculo();

        setTitle("Cadastro de Veículo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 0, 6));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setFont(font);
        modeloTextField = new JTextField();
        modeloTextField.setFont(font);
        mainPanel.add(modeloLabel);
        mainPanel.add(modeloTextField);

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setFont(font);
        marcaTextField = new JTextField();
        marcaTextField.setFont(font);
        mainPanel.add(marcaLabel);
        mainPanel.add(marcaTextField);

        JLabel anoLabel = new JLabel("Ano:");
        anoLabel.setFont(font);
        anoTextField = new JTextField();
        anoTextField.setFont(font);
        mainPanel.add(anoLabel);
        mainPanel.add(anoTextField);

        JLabel valorLabel = new JLabel("Valor da Diária:");
        valorLabel.setFont(font);
        valorTextField = new JTextField();
        valorTextField.setFont(font);
        mainPanel.add(valorLabel);
        mainPanel.add(valorTextField);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(font);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });
        mainPanel.add(cadastrarButton);

        JButton excluirButton = new JButton("Deletar");
        excluirButton.setFont(font);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirVeiculo();
                
            }
        });
        mainPanel.add(excluirButton);     
        
        
        JButton editarButton = new JButton("Editar");
        editarButton.setFont(font);
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarButton();
                
            }
        });
        mainPanel.add(editarButton);       


        

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setFont(font);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            }
        });
        mainPanel.add(voltarButton);

        add(mainPanel);
        setVisible(true);
    }

    protected void editarButton() {
        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano = 0;
        double valorDiaria = 0.0;

        try {
            ano = Integer.parseInt(anoTextField.getText());
            valorDiaria = Double.parseDouble(valorTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor da Diária devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroVeiculo.atualizarVeiculo(modelo, marca, ano, valorDiaria);

        JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
    }

    protected void excluirVeiculo() {
        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano = 0;
        double valorDiaria = 0.0;

        try {
            ano = Integer.parseInt(anoTextField.getText());
            valorDiaria = Double.parseDouble(valorTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor da Diária devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroVeiculo.removerVeiculo(modelo, marca, ano, valorDiaria);

        JOptionPane.showMessageDialog(this, "Veículo removido com sucesso!");
    }

    private void adicionarVeiculo() {
        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano = 0;
        double valorDiaria = 0.0;

        try {
            ano = Integer.parseInt(anoTextField.getText());
            valorDiaria = Double.parseDouble(valorTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor da Diária devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroVeiculo.adicionarVeiculo(modelo, marca, ano, valorDiaria);

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
