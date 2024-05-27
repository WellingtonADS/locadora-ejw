package telas;

import cadastro.CadastroVeiculo;
import modelo.Veiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField modeloTextField;
    private JTextField marcaTextField;
    private JTextField anoTextField;
    private JTextField valorTextField;
    private CadastroVeiculo cadastroVeiculo;
    private JTable veiculosTable;
    private DefaultTableModel tableModel;
    private JButton cadastrarButton;
    private JButton excluirButton;
    private JButton editarButton;
    private JButton voltarButton;

    public TelaCadastroVeiculo() {
        cadastroVeiculo = new CadastroVeiculo();

        setTitle("Cadastro de Veículo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel para os campos de entrada
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setFont(font);
        modeloTextField = new JTextField();
        modeloTextField.setFont(font);
        formPanel.add(modeloLabel);
        formPanel.add(modeloTextField);

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setFont(font);
        marcaTextField = new JTextField();
        marcaTextField.setFont(font);
        formPanel.add(marcaLabel);
        formPanel.add(marcaTextField);

        JLabel anoLabel = new JLabel("Ano:");
        anoLabel.setFont(font);
        anoTextField = new JTextField();
        anoTextField.setFont(font);
        formPanel.add(anoLabel);
        formPanel.add(anoTextField);

        JLabel valorLabel = new JLabel("Valor da Diária:");
        valorLabel.setFont(font);
        valorTextField = new JTextField();
        valorTextField.setFont(font);
        formPanel.add(valorLabel);
        formPanel.add(valorTextField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(font);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo();
            }
        });

        excluirButton = new JButton("Excluir");
        excluirButton.setFont(font);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirVeiculo();
            }
        });

        editarButton = new JButton("Editar");
        editarButton.setFont(font);
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarVeiculo();
            }
        });

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

        formPanel.add(cadastrarButton);
        formPanel.add(excluirButton);
        formPanel.add(editarButton);
        formPanel.add(voltarButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Configuração da tabela de veículos
        String[] colunas = {"Modelo", "Marca", "Ano", "Valor Diária"};
        tableModel = new DefaultTableModel(colunas, 0);
        veiculosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(veiculosTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Listener para seleção na tabela
        veiculosTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = veiculosTable.getSelectedRow();
                if (selectedRow != -1) {
                    Veiculo veiculoSelecionado = cadastroVeiculo.getListaVeiculos().get(selectedRow);
                    preencherCampos(veiculoSelecionado);
                }
            }
        });

        add(mainPanel);
        setVisible(true);

        atualizarTabela();
    }

    private void atualizarTabela() {
        List<Veiculo> listaVeiculos = cadastroVeiculo.getListaVeiculos();
        tableModel.setRowCount(0); // Limpa a tabela

        for (Veiculo veiculo : listaVeiculos) {
            Object[] rowData = {
                veiculo.getModelo(),
                veiculo.getMarca(),
                veiculo.getAno(),
                veiculo.getValorDiaria()
            };
            tableModel.addRow(rowData);
        }
    }

    private void adicionarVeiculo() {
        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano;
        double valorDiaria;

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

        cadastroVeiculo.adicionarVeiculo(new Veiculo(modelo, marca, ano, valorDiaria));
        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");

        limparCampos();
        atualizarTabela();
    }

    private void excluirVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoRemover = cadastroVeiculo.getListaVeiculos().get(selectedRow);
        cadastroVeiculo.removerVeiculo(veiculoRemover.getModelo(), veiculoRemover.getMarca(), veiculoRemover.getAno(), veiculoRemover.getValorDiaria());

        limparCampos();
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Veículo removido com sucesso!");
    }

    private void editarVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String modelo = modeloTextField.getText();
        String marca = marcaTextField.getText();
        int ano;
        double valorDiaria;

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

        Veiculo veiculoAtualizado = new Veiculo(modelo, marca, ano, valorDiaria);
        cadastroVeiculo.atualizarVeiculo(veiculoAtualizado);

        limparCampos();
        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
    }

    private void preencherCampos(Veiculo veiculo) {
        modeloTextField.setText(veiculo.getModelo());
        marcaTextField.setText(veiculo.getMarca());
        anoTextField.setText(String.valueOf(veiculo.getAno()));
        valorTextField.setText(String.valueOf(veiculo.getValorDiaria()));
    }

    private void limparCampos() {
        modeloTextField.setText("");
        marcaTextField.setText("");
        anoTextField.setText("");
        valorTextField.setText("");
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
