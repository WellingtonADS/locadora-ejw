package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal extends JFrame {
    private JButton btnCadastroPessoa;
    private JButton btnCadastroVeiculo;
    private JButton btnAluguelVeiculo;

    public TelaPrincipal() {
        setTitle("Tela Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Cria o painel principal com layout BoxLayout vertical
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        // Cria um painel para os botões com layout FlowLayout centralizado
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(buttonPanel);

        // Cria os botões
        btnCadastroPessoa = new JButton("Cadastro de Pessoa");
        btnCadastroVeiculo = new JButton("Cadastro de Veículo");
        btnAluguelVeiculo = new JButton("Aluguel de Veículo");

        // Adiciona os botões ao painel de botões
        buttonPanel.add(btnCadastroPessoa);
        buttonPanel.add(btnCadastroVeiculo);
        buttonPanel.add(btnAluguelVeiculo);

        // Define a margem interna da tela principal
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        // Define o tamanho preferido dos botões para preencher horizontalmente o painel
        Dimension buttonSize = new Dimension(200, 40); // Largura e altura desejadas dos botões
        btnCadastroPessoa.setPreferredSize(buttonSize);
        btnCadastroVeiculo.setPreferredSize(buttonSize);
        btnAluguelVeiculo.setPreferredSize(buttonSize);

        // Adiciona listeners de ação aos botões para abrir as telas correspondentes
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
