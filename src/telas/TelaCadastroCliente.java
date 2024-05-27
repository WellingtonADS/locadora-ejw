package telas;

import cadastro.CadastroCliente;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {
    private JTextField nomeTextField;
    private JTextField enderecoTextField;
    private JTextField telefoneTextField;
    private JRadioButton pessoaFisicaRadioButton;
    private JRadioButton pessoaJuridicaRadioButton;
    private ButtonGroup tipoPessoaButtonGroup;
    private JButton cadastrarButton;
    private JButton excluirButton;
    private JButton editarButton;
    private JButton btnVoltar;
    private JTable clientesTable;
    private DefaultTableModel tableModel;

    private CadastroCliente cadastroCliente;

    public TelaCadastroCliente() {
        cadastroCliente = new CadastroCliente();

        setTitle("Cadastro de Cliente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel para os campos de entrada e botões
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        Font font = new Font("Arial", Font.PLAIN, 12);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(font);
        nomeTextField = new JTextField();
        nomeTextField.setFont(font);
        formPanel.add(nomeLabel);
        formPanel.add(nomeTextField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setFont(font);
        enderecoTextField = new JTextField();
        enderecoTextField.setFont(font);
        formPanel.add(enderecoLabel);
        formPanel.add(enderecoTextField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setFont(font);
        telefoneTextField = new JTextField();
        telefoneTextField.setFont(font);
        formPanel.add(telefoneLabel);
        formPanel.add(telefoneTextField);

        // Radio Button Group for type selection
        tipoPessoaButtonGroup = new ButtonGroup();

        pessoaFisicaRadioButton = new JRadioButton("Pessoa Física");
        pessoaFisicaRadioButton.setFont(font);
        pessoaJuridicaRadioButton = new JRadioButton("Pessoa Jurídica");
        pessoaJuridicaRadioButton.setFont(font);

        tipoPessoaButtonGroup.add(pessoaFisicaRadioButton);
        tipoPessoaButtonGroup.add(pessoaJuridicaRadioButton);

        JPanel radioPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        radioPanel.add(pessoaFisicaRadioButton);
        radioPanel.add(pessoaJuridicaRadioButton);

        formPanel.add(new JLabel("Tipo de Pessoa:"));
        formPanel.add(radioPanel);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(font);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCliente();
            }
        });

        excluirButton = new JButton("Excluir");
        excluirButton.setFont(font);
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerCliente();
            }
        });

        editarButton = new JButton("Editar");
        editarButton.setFont(font);
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCliente();
            }
        });

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(font);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaPrincipal();
            }
        });

        formPanel.add(cadastrarButton);
        formPanel.add(excluirButton);
        formPanel.add(editarButton);
        formPanel.add(btnVoltar);

        mainPanel.add(formPanel, BorderLayout.NORTH);

        // Configuração da tabela de clientes
        String[] colunas = {"Nome", "Endereço", "Telefone", "Tipo Pessoa"};
        tableModel = new DefaultTableModel(colunas, 0);
        clientesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(clientesTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Listener para seleção na tabela
        clientesTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = clientesTable.getSelectedRow();
                if (selectedRow != -1) {
                    Cliente clienteSelecionado = cadastroCliente.getListaClientes().get(selectedRow);
                    preencherCampos(clienteSelecionado);
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    private void adicionarCliente() {
        String nome = nomeTextField.getText();
        String endereco = enderecoTextField.getText();
        String telefone = telefoneTextField.getText();
        String tipoPessoa = null;

        if (pessoaFisicaRadioButton.isSelected()) {
            tipoPessoa = "Pessoa Física";
        } else if (pessoaJuridicaRadioButton.isSelected()) {
            tipoPessoa = "Pessoa Jurídica";
        }

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || tipoPessoa == null) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos e selecione o tipo de pessoa.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, endereco, telefone, tipoPessoa);
        cadastroCliente.adicionarCliente(cliente);
        adicionarNaTabela(cliente);
        limparCampos();

        JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
    }

    private void removerCliente() {
        int selectedRow = clientesTable.getSelectedRow();
        if (selectedRow != -1) {
            Cliente clienteRemover = cadastroCliente.getListaClientes().get(selectedRow);
            cadastroCliente.removerCliente(clienteRemover.getNome());
            atualizarTabela();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Cliente removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para remover.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarCliente() {
        int selectedRow = clientesTable.getSelectedRow();
        if (selectedRow != -1) {
            String nomeAntigo = cadastroCliente.getListaClientes().get(selectedRow).getNome();
            String nome = nomeTextField.getText();
            String endereco = enderecoTextField.getText();
            String telefone = telefoneTextField.getText();
            String tipoPessoa = pessoaFisicaRadioButton.isSelected() ? "Pessoa Física" : "Pessoa Jurídica";

            Cliente clienteAtualizado = new Cliente(nome, endereco, telefone, tipoPessoa);
            if (cadastroCliente.atualizarCliente(nomeAntigo, clienteAtualizado)) {
                atualizarTabela();
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar cliente.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void voltarParaTelaPrincipal() {
        setVisible(false);
        dispose();
        // Chamar a tela principal ou outra tela desejada
    }

    private void adicionarNaTabela(Cliente cliente) {
        tableModel.addRow(new Object[]{cliente.getNome(), cliente.getEndereco(),
                cliente.getTelefone(), cliente.getTipoPessoa()});
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Cliente cliente : cadastroCliente.getListaClientes()) {
            tableModel.addRow(new Object[]{cliente.getNome(), cliente.getEndereco(),
                    cliente.getTelefone(), cliente.getTipoPessoa()});
        }
    }

    private void preencherCampos(Cliente cliente) {
        nomeTextField.setText(cliente.getNome());
        enderecoTextField.setText(cliente.getEndereco());
        telefoneTextField.setText(cliente.getTelefone());
        if (cliente.getTipoPessoa().equals("Pessoa Física")) {
            pessoaFisicaRadioButton.setSelected(true);
        } else if (cliente.getTipoPessoa().equals("Pessoa Jurídica")) {
            pessoaJuridicaRadioButton.setSelected(true);
        }
    }

    private void limparCampos() {
        nomeTextField.setText("");
        enderecoTextField.setText("");
        telefoneTextField.setText("");
        tipoPessoaButtonGroup.clearSelection();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroCliente();
            }
        });
    }
}
