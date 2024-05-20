package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cadastro.CadastroCliente;
import cadastro.CadastroVeiculo;
import modelo.Cliente;
import modelo.Veiculo;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TelaAluguelVeiculo extends JFrame {
    private JComboBox<String> pessoaComboBox;
    private JComboBox<String> veiculoComboBox;
    private JTextField dataInicioTextField;
    private JTextField dataFimTextField;
    private JButton confirmarButton;
    private JButton voltarButton;
    private CadastroCliente cadastroCliente;
    private CadastroVeiculo cadastroVeiculo;

    /**
     * 
     */
    public TelaAluguelVeiculo() {
        cadastroCliente = new CadastroCliente();
        cadastroVeiculo = new CadastroVeiculo();

        setTitle("Aluguel de Veículo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 0, 6));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel pessoaLabel = new JLabel("Pessoa:");
        pessoaLabel.setFont(font);
        pessoaComboBox = new JComboBox<>();
        popularComboBoxClientes(); // Preenche o combo box de clientes
        mainPanel.add(pessoaLabel);
        mainPanel.add(pessoaComboBox);

        JLabel veiculoLabel = new JLabel("Veículo:");
        veiculoLabel.setFont(font);
        veiculoComboBox = new JComboBox<>();
        popularComboBoxVeiculos(); // Preenche o combo box de veículos
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
        confirmarButton.setFont(font);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarVeiculo();
            }
        });
        mainPanel.add(confirmarButton);

        voltarButton = new JButton("Voltar");
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

    private void alugarVeiculo() {
        String pessoaSelecionada = (String) pessoaComboBox.getSelectedItem();
        String veiculoSelecionado = (String) veiculoComboBox.getSelectedItem();
        String dataInicioStr = dataInicioTextField.getText();
        String dataFimStr = dataFimTextField.getText();

        if (pessoaSelecionada == null || veiculoSelecionado == null || dataInicioStr.isEmpty() || dataFimStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = cadastroCliente.buscarClientePorNome(pessoaSelecionada);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculo = cadastroVeiculo.buscarVeiculoPorModelo(veiculoSelecionado);
        if (veiculo == null) {
            JOptionPane.showMessageDialog(this, "Veículo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dataInicio;
        LocalDate dataFim;
        try {
            dataInicio = LocalDate.parse(dataInicioStr);
            dataFim = LocalDate.parse(dataFimStr);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aqui você poderia fazer o processo de aluguel utilizando as informações obtidas
        // Por exemplo, criar um objeto Aluguel e manipular as classes de cadastro

        JOptionPane.showMessageDialog(this, "Aluguel confirmado com sucesso!");
    }

    private void popularComboBoxClientes() {
        // Simulação: Adiciona alguns clientes ao combo box
        pessoaComboBox.addItem("João");
        pessoaComboBox.addItem("Maria");
        pessoaComboBox.addItem("José");
        pessoaComboBox.addItem("Ana");
    }

    private void popularComboBoxVeiculos() {
        // Simulação: Adiciona alguns veículos ao combo box
        veiculoComboBox.addItem("Gol");
        veiculoComboBox.addItem("Onix");
        veiculoComboBox.addItem("Corolla");
        veiculoComboBox.addItem("HB20");
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
