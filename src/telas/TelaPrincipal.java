package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Classe que representa a tela principal da aplicação.
 */
public class TelaPrincipal extends JFrame {

    private JButton btnCadastroCliente;
    private JButton btnCadastroVeiculo;
    private JButton btnAluguelVeiculo;

    public TelaPrincipal() {
        setTitle("Tela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(buttonPanel);

        btnCadastroCliente = new JButton("Cadastro de Cliente");
        btnCadastroVeiculo = new JButton("Cadastro de Veículo");
        btnAluguelVeiculo = new JButton("Aluguel de Veículo");

        buttonPanel.add(btnCadastroCliente);
        buttonPanel.add(btnCadastroVeiculo);
        buttonPanel.add(btnAluguelVeiculo);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        Dimension buttonSize = new Dimension(200, 40);
        btnCadastroCliente.setPreferredSize(buttonSize);
        btnCadastroVeiculo.setPreferredSize(buttonSize);
        btnAluguelVeiculo.setPreferredSize(buttonSize);

        btnCadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
                telaCadastroCliente.setVisible(true);
                
            }
        });

        btnCadastroVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo();
                telaCadastroVeiculo.setVisible(true);
            }
        });

        btnAluguelVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAluguelVeiculo telaAluguelVeiculo = new TelaAluguelVeiculo();
                telaAluguelVeiculo.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            }
        });
    }
}
