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
import java.time.temporal.ChronoUnit;

public class TelaAluguelVeiculo extends JFrame {
    private JComboBox<Cliente> pessoaComboBox;
    private JComboBox<Veiculo> veiculoComboBox;
    private JTextField dataInicioTextField;
    private JTextField dataFimTextField;
    private JTextField valorDiariaTextField;
    private JTextField valorTextField;
    private JButton confirmarButton;
    private JButton voltarButton;
    private CadastroCliente cadastroCliente;
    private CadastroVeiculo cadastroVeiculo;

    public TelaAluguelVeiculo() {
        cadastroCliente = new CadastroCliente();
        cadastroVeiculo = new CadastroVeiculo();

        setTitle("Aluguel de Veículo");
        setSize(400, 350); // Ajuste para acomodar os novos campos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2, 0, 6)); // Ajuste para incluir os novos campos
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
        veiculoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDiariaVeiculoSelecionado();
            }
        });
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

        JLabel valorDiariaLabel = new JLabel("Valor Diária:");
        valorDiariaTextField = new JTextField();
        valorDiariaTextField.setEditable(false); // Campo de texto apenas para exibição
        mainPanel.add(valorDiariaLabel);
        mainPanel.add(valorDiariaTextField);

        JLabel valorLabel = new JLabel("Valor Total:");
        valorTextField = new JTextField();
        valorTextField.setEditable(false); // Campo de texto apenas para exibição
        mainPanel.add(valorLabel);
        mainPanel.add(valorTextField);

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
        Cliente clienteSelecionado = (Cliente) pessoaComboBox.getSelectedItem();
        Veiculo veiculoSelecionado = (Veiculo) veiculoComboBox.getSelectedItem();
        String dataInicioStr = dataInicioTextField.getText();
        String dataFimStr = dataFimTextField.getText();

        if (clienteSelecionado == null || veiculoSelecionado == null || dataInicioStr.isEmpty() || dataFimStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        // Calcular número de dias de aluguel
        long diasAluguel = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1; // +1 porque inclui o último dia

        // Validar se o número de dias de aluguel é válido
        if (diasAluguel <= 0) {
            JOptionPane.showMessageDialog(this, "Data de fim deve ser posterior à data de início.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calcular valor total do aluguel
        double valorTotal = diasAluguel * veiculoSelecionado.getValorDiaria();

        // Atualizar os campos de texto com os valores calculados
        valorDiariaTextField.setText(String.format("R$ %.2f", veiculoSelecionado.getValorDiaria()));
        valorTextField.setText(String.format("R$ %.2f", valorTotal));

        // Exibir mensagem de confirmação
        JOptionPane.showMessageDialog(this, String.format("Aluguel confirmado com sucesso!\n\n" +
                "Veículo: %s\n" +
                "Valor da Diária: R$ %.2f\n" +
                "Número de Dias: %d\n" +
                "Valor Total: R$ %.2f",
                veiculoSelecionado.getModelo(), veiculoSelecionado.getValorDiaria(), diasAluguel, valorTotal));
    }

    private void popularComboBoxClientes() {
        // Obter clientes do cadastro e adicioná-los ao combo box
        for (Cliente cliente : cadastroCliente.getClientes()) {
            pessoaComboBox.addItem(cliente);
        }
    }

    private void popularComboBoxVeiculos() {
        // Obter veículos do cadastro e adicioná-los ao combo box
        for (Veiculo veiculo : cadastroVeiculo.getVeiculos()) {
            veiculoComboBox.addItem(veiculo);
        }
    }

    private void mostrarDiariaVeiculoSelecionado() {
        Veiculo veiculoSelecionado = (Veiculo) veiculoComboBox.getSelectedItem();
        if (veiculoSelecionado != null) {
            valorDiariaTextField.setText(String.format("R$ %.2f", veiculoSelecionado.getValorDiaria()));
        }
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
