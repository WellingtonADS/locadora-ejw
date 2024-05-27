package telas;


import javax.swing.*;//importa todas as classes do pacote javax.swing
import java.awt.*;//importa todas as classes do pacote java.awt
import java.awt.event.*;//importa todas as classes do pacote java.awt.event



public class TelaPrincipal extends JFrame {

    private JButton btnCadastroCliente; // Botão para cadastro de cliente
    private JButton btnCadastroVeiculo; // Botão para cadastro de veículo
    private JButton btnAluguelVeiculo; // Botão para aluguel de veículo

    public TelaPrincipal() {
        setTitle("Tela Principal"); // Define o título da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
        setSize(400, 300); // Define o tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel mainPanel = new JPanel(); // Painel principal
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Define o layout do painel principal
        add(mainPanel); // Adiciona o painel principal à janela

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Painel para os botões
        mainPanel.add(buttonPanel); // Adiciona o painel de botões ao painel principal

        btnCadastroCliente = new JButton("Cadastro de Cliente"); // Cria o botão de cadastro de cliente
        btnCadastroVeiculo = new JButton("Cadastro de Veículo"); // Cria o botão de cadastro de veículo
        btnAluguelVeiculo = new JButton("Aluguel de Veículo"); // Cria o botão de aluguel de veículo

        buttonPanel.add(btnCadastroCliente); // Adiciona o botão de cadastro de cliente ao painel de botões
        buttonPanel.add(btnCadastroVeiculo); // Adiciona o botão de cadastro de veículo ao painel de botões
        buttonPanel.add(btnAluguelVeiculo); // Adiciona o botão de aluguel de veículo ao painel de botões

        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Define as margens do painel principal

        Dimension buttonSize = new Dimension(200, 40); // Define o tamanho dos botões
        btnCadastroCliente.setPreferredSize(buttonSize); // Define o tamanho do botão de cadastro de cliente
        btnCadastroVeiculo.setPreferredSize(buttonSize); // Define o tamanho do botão de cadastro de veículo
        btnAluguelVeiculo.setPreferredSize(buttonSize); // Define o tamanho do botão de aluguel de veículo

        btnCadastroCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(); // Cria a tela de cadastro de cliente
                telaCadastroCliente.setVisible(true); // Exibe a tela de cadastro de cliente
            }
        });

        btnCadastroVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo(); // Cria a tela de cadastro de veículo
                telaCadastroVeiculo.setVisible(true); // Exibe a tela de cadastro de veículo
            }
        });

        btnAluguelVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAluguelVeiculo telaAluguelVeiculo = new TelaAluguelVeiculo(); // Cria a tela de aluguel de veículo
                telaAluguelVeiculo.setVisible(true); // Exibe a tela de aluguel de veículo
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Cria a tela principal
                telaPrincipal.setVisible(true); // Exibe a tela principal
            }
        });
    }
}
