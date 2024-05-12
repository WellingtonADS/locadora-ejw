package telas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private JButton btnCadastroPessoa;
    private JButton btnCadastroVeiculo;
    private JButton btnAluguelVeiculo;

    public TelaPrincipal() {
        setTitle("Tela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        btnCadastroPessoa = new JButton("Cadastro de Pessoa");
        btnCadastroVeiculo = new JButton("Cadastro de Veículo");
        btnAluguelVeiculo = new JButton("Aluguel de Veículo");

        btnCadastroPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastroPessoa telaCadastroPessoa = new TelaCadastroPessoa();
                telaCadastroPessoa.setVisible(true);
            }
        });

        btnCadastroVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo();
                telaCadastroVeiculo.setVisible(true);
            }
        });

        btnAluguelVeiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaAluguelVeiculo telaAluguelVeiculo = new TelaAluguelVeiculo();
                telaAluguelVeiculo.setVisible(true);
            }
        });

        setLayout(new FlowLayout());
        add(btnCadastroPessoa);
        add(btnCadastroVeiculo);
        add(btnAluguelVeiculo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            }
        });
    }
}