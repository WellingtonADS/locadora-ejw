package telas; // Pacote que contém a classe TelaPrincipal

import javax.swing.*; // Importação da classe Swing
import java.awt.*; // Importação da classe AWT
import java.awt.event.*; // Importação da classe de eventos




/**
 * Classe que representa a tela principal da aplicação.
 */
public class TelaPrincipal extends JFrame { // Classe TelaPrincipal que herda da classe JFrame
    private JButton btnCadastroPessoa; // Botão para cadastro de pessoa
    private JButton btnCadastroVeiculo; // Botão para cadastro de veículo
    private JButton btnAluguelVeiculo; // Botão para aluguel de veículo

    public TelaPrincipal() { // Construtor da classe TelaPrincipal
        setTitle("Tela Principal"); // Define o título da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
        setSize(400, 300); // Define o tamanho da janela
        setLocationRelativeTo(null); // Define a posição da janela como centralizada

        JPanel mainPanel = new JPanel(); // Painel principal
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Define o layout do painel principal
        add(mainPanel); // Adiciona o painel principal à janela

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Painel para os botões
        mainPanel.add(buttonPanel); // Adiciona o painel de botões ao painel principal

        btnCadastroPessoa = new JButton("Cadastro de Pessoa"); // Botão para cadastro de pessoa
        btnCadastroVeiculo = new JButton("Cadastro de Veículo"); // Botão para cadastro de veículo
        btnAluguelVeiculo = new JButton("Aluguel de Veículo"); // Botão para aluguel de veículo

        buttonPanel.add(btnCadastroPessoa); // Adiciona o botão de cadastro de pessoa ao painel de botões
        buttonPanel.add(btnCadastroVeiculo); // Adiciona o botão de cadastro de veículo ao painel de botões
        buttonPanel.add(btnAluguelVeiculo); // Adiciona o botão de aluguel de veículo ao painel de botões

        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10)); // Define a borda do painel principal

        Dimension buttonSize = new Dimension(200, 40); // Define o tamanho dos botões
        btnCadastroPessoa.setPreferredSize(buttonSize); // Define o tamanho do botão de cadastro de pessoa
        btnCadastroVeiculo.setPreferredSize(buttonSize); // Define o tamanho do botão de cadastro de veículo
        btnAluguelVeiculo.setPreferredSize(buttonSize); // Define o tamanho do botão de aluguel de veículo

        btnCadastroPessoa.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão de cadastro de pessoa
            public void actionPerformed(ActionEvent e) {
                TelaCadastroPessoa telaCadastroPessoa = new TelaCadastroPessoa(); // Cria uma instância da classe TelaCadastroPessoa
                telaCadastroPessoa.setVisible(true); // Torna a tela de cadastro de pessoa visível
            }
        });

        btnCadastroVeiculo.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão de cadastro de veículo
            public void actionPerformed(ActionEvent e) {
                TelaCadastroVeiculo telaCadastroVeiculo = new TelaCadastroVeiculo(); // Cria uma instância da classe TelaCadastroVeiculo
                telaCadastroVeiculo.setVisible(true); // Torna a tela de cadastro de veículo visível
            }
        });

        btnAluguelVeiculo.addActionListener(new ActionListener() { // Adiciona um ouvinte de ação ao botão de aluguel de veículo
            public void actionPerformed(ActionEvent e) {
                TelaAluguelVeiculo telaAluguelVeiculo = new TelaAluguelVeiculo(); // Cria uma instância da classe TelaAluguelVeiculo
                telaAluguelVeiculo.setVisible(true); // Torna a tela de aluguel de veículo visível
            }
        });
    }

    public static void main(String[] args) { // Método principal
        SwingUtilities.invokeLater(new Runnable() { // Cria uma nova thread para executar a interface gráfica
            public void run() {
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Cria uma instância da classe TelaPrincipal
                telaPrincipal.setVisible(true); // Torna a tela principal visível
            }
        });
    }
}
