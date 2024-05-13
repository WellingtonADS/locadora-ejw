package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAluguelVeiculo extends JFrame {
    private JComboBox<String> pessoaComboBox;
    private JComboBox<String> veiculoComboBox;
    private JTextField dataInicioTextField;
    private JTextField dataFimTextField;
    private JButton confirmarButton;
    private JButton voltarButton;

    public TelaAluguelVeiculo() {
        setTitle("Aluguel de Veículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 0, 6));
        
        // Define a margem interna da tela principal
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        
        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel pessoaLabel = new JLabel("Pessoa:");
        pessoaLabel.setFont(font);
        pessoaComboBox = new JComboBox<>();
        
        mainPanel.add(pessoaLabel);
        mainPanel.add(pessoaComboBox);

        JLabel veiculoLabel = new JLabel("Veículo:");
        veiculoComboBox = new JComboBox<>();
        // Adicione aqui a lógica para preencher o JComboBox com os veículos cadastrados
        mainPanel.add(veiculoLabel);
        mainPanel.add(veiculoComboBox);

        JLabel dataInicioLabel = new JLabel("Data de Início:");
        dataInicioTextField = new JTextField();
        mainPanel.add(dataInicioLabel);
        mainPanel.add(dataInicioTextField);

        JLabel dataFimLabel = new JLabel("Data de Fim:");
        dataFimTextField = new JTextField();
        mainPanel.add(dataFimLabel);
        mainPanel.add(dataFimTextField);

        confirmarButton = new JButton("Confirmar Aluguel");
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarVeiculo();
            }
        });
        mainPanel.add(confirmarButton);
        
        voltarButton = new JButton("Voltar");
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

    private void alugarVeiculo() {
        String pessoaSelecionada = (String) pessoaComboBox.getSelectedItem();
        String veiculoSelecionado = (String) veiculoComboBox.getSelectedItem();
        String dataInicio = dataInicioTextField.getText();
        String dataFim = dataFimTextField.getText();

        // Verifica se todos os campos obrigatórios estão preenchidos
        if (pessoaSelecionada == null || veiculoSelecionado == null || dataInicio.isEmpty() || dataFim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Não realiza o aluguel se algum campo estiver vazio
        }

        // Adicione aqui a lógica para confirmar o aluguel e calcular o valor total

        JOptionPane.showMessageDialog(this, "Aluguel confirmado com sucesso!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaAluguelVeiculo();
            }
        });
    }
}
