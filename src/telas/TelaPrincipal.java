
package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Classe que representa a tela principal da aplicação.
 */
public class TelaPrincipal extends JFrame {
    private JButton btnCadastroPessoa;
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

        btnCadastroPessoa = new JButton("Cadastro de Pessoa");
        btnCadastroVeiculo = new JButton("Cadastro de Veículo");
        btnAluguelVeiculo = new JButton("Aluguel de Veículo");

        buttonPanel.add(btnCadastroPessoa);
        buttonPanel.add(btnCadastroVeiculo);
        buttonPanel.add(btnAluguelVeiculo);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        Dimension buttonSize = new Dimension(200, 40);
        btnCadastroPessoa.setPreferredSize(buttonSize);
        btnCadastroVeiculo.setPreferredSize(buttonSize);
        btnAluguelVeiculo.setPreferredSize(buttonSize);

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
