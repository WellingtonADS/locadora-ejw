package telas;
/**
 * Classe responsável por exibir a tela de cadastro de clientes e gerenciar as ações dos botões e campos de entrada.
 * Esta classe estende a classe JFrame e implementa a interface ActionListener.
 */

import cadastro.CadastroCliente;
import modelo.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroCliente extends JFrame {

    private JTextField nomeTextField; // Campo de texto para o nome do cliente
    private JTextField enderecoTextField; // Campo de texto para o endereço do cliente
    private JTextField telefoneTextField; // Campo de texto para o telefone do cliente
    private JRadioButton pessoaFisicaRadioButton; // Botão de rádio para selecionar pessoa física
    private JRadioButton pessoaJuridicaRadioButton; // Botão de rádio para selecionar pessoa jurídica
    private ButtonGroup tipoPessoaButtonGroup; // Grupo de botões de rádio para selecionar o tipo de pessoa
    private JButton cadastrarButton; // Botão para cadastrar um cliente
    private JButton excluirButton; // Botão para excluir um cliente
    private JButton editarButton; // Botão para editar um cliente
    private JButton btnVoltar; // Botão para voltar para a tela principal
    private JTable clientesTable; // Tabela para exibir os clientes cadastrados
    private DefaultTableModel tableModel; // Modelo da tabela

    private CadastroCliente cadastroCliente; // Instância da classe CadastroCliente

    public TelaCadastroCliente() {
        cadastroCliente = new CadastroCliente(); // Inicializa a instância de CadastroCliente

        setTitle("Cadastro de Cliente"); // Define o título da janela
        setSize(400, 400); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel mainPanel = new JPanel(new BorderLayout()); // Painel principal com layout BorderLayout
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Define uma borda vazia para o painel

        // Painel para os campos de entrada e botões
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5)); // Painel com layout GridLayout
        Font font = new Font("Arial", Font.PLAIN, 12); // Define a fonte para os componentes

        JLabel nomeLabel = new JLabel("Nome:"); // Rótulo para o campo de nome
        nomeLabel.setFont(font); // Define a fonte para o rótulo
        nomeTextField = new JTextField(); // Campo de texto para o nome
        nomeTextField.setFont(font); // Define a fonte para o campo de texto
        formPanel.add(nomeLabel); // Adiciona o rótulo ao painel
        formPanel.add(nomeTextField); // Adiciona o campo de texto ao painel

        JLabel enderecoLabel = new JLabel("Endereço:"); // Rótulo para o campo de endereço
        enderecoLabel.setFont(font); // Define a fonte para o rótulo
        enderecoTextField = new JTextField(); // Campo de texto para o endereço
        enderecoTextField.setFont(font); // Define a fonte para o campo de texto
        formPanel.add(enderecoLabel); // Adiciona o rótulo ao painel
        formPanel.add(enderecoTextField); // Adiciona o campo de texto ao painel

        JLabel telefoneLabel = new JLabel("Telefone:"); // Rótulo para o campo de telefone
        telefoneLabel.setFont(font); // Define a fonte para o rótulo
        telefoneTextField = new JTextField(); // Campo de texto para o telefone
        telefoneTextField.setFont(font); // Define a fonte para o campo de texto
        formPanel.add(telefoneLabel); // Adiciona o rótulo ao painel
        formPanel.add(telefoneTextField); // Adiciona o campo de texto ao painel

        // Grupo de botões de rádio para selecionar o tipo de pessoa
        tipoPessoaButtonGroup = new ButtonGroup();

        pessoaFisicaRadioButton = new JRadioButton("Pessoa Física"); // Botão de rádio para pessoa física
        pessoaFisicaRadioButton.setFont(font); // Define a fonte para o botão de rádio
        pessoaJuridicaRadioButton = new JRadioButton("Pessoa Jurídica"); // Botão de rádio para pessoa jurídica
        pessoaJuridicaRadioButton.setFont(font); // Define a fonte para o botão de rádio

        tipoPessoaButtonGroup.add(pessoaFisicaRadioButton); // Adiciona o botão de rádio ao grupo
        tipoPessoaButtonGroup.add(pessoaJuridicaRadioButton); // Adiciona o botão de rádio ao grupo

        JPanel radioPanel = new JPanel(new GridLayout(1, 2, 5, 5)); // Painel com layout GridLayout
        radioPanel.add(pessoaFisicaRadioButton); // Adiciona o botão de rádio ao painel
        radioPanel.add(pessoaJuridicaRadioButton); // Adiciona o botão de rádio ao painel

        formPanel.add(new JLabel("Tipo de Pessoa:")); // Adiciona um rótulo ao painel
        formPanel.add(radioPanel); // Adiciona o painel de botões de rádio ao painel principal

        cadastrarButton = new JButton("Cadastrar"); // Botão para cadastrar um cliente
        cadastrarButton.setFont(font); // Define a fonte para o botão
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCliente(); // Chama o método para adicionar um cliente
            }
        });

        excluirButton = new JButton("Excluir"); // Botão para excluir um cliente
        excluirButton.setFont(font); // Define a fonte para o botão
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerCliente(); // Chama o método para remover um cliente
            }
        });

        editarButton = new JButton("Editar"); // Botão para editar um cliente
        editarButton.setFont(font); // Define a fonte para o botão
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarCliente(); // Chama o método para atualizar um cliente
            }
        });

        btnVoltar = new JButton("Voltar"); // Botão para voltar para a tela principal
        btnVoltar.setFont(font); // Define a fonte para o botão
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaPrincipal(); // Chama o método para voltar para a tela principal
            }
        });

        formPanel.add(cadastrarButton); // Adiciona o botão de cadastrar ao painel
        formPanel.add(excluirButton); // Adiciona o botão de excluir ao painel
        formPanel.add(editarButton); // Adiciona o botão de editar ao painel
        formPanel.add(btnVoltar); // Adiciona o botão de voltar ao painel

        mainPanel.add(formPanel, BorderLayout.NORTH); // Adiciona o painel de campos e botões ao painel principal

        // Configuração da tabela de clientes
        String[] colunas = { "Nome", "Endereço", "Telefone", "Tipo Pessoa" }; // Array com os nomes das colunas
        tableModel = new DefaultTableModel(colunas, 0); // Cria o modelo da tabela
        clientesTable = new JTable(tableModel); // Cria a tabela com base no modelo
        JScrollPane scrollPane = new JScrollPane(clientesTable); // Cria um painel de rolagem para a tabela
        mainPanel.add(scrollPane, BorderLayout.CENTER); // Adiciona o painel de rolagem ao painel principal

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

        add(mainPanel); // Adiciona o painel principal à janela
        setVisible(true); // Torna a janela visível
    }

    private void adicionarCliente() {
        String nome = nomeTextField.getText(); // Obtém o nome do campo de texto
        String endereco = enderecoTextField.getText(); // Obtém o endereço do campo de texto
        String telefone = telefoneTextField.getText(); // Obtém o telefone do campo de texto
        String tipoPessoa = null; // Variável para armazenar o tipo de pessoa selecionado

        if (pessoaFisicaRadioButton.isSelected()) {
            tipoPessoa = "Pessoa Física"; // Define o tipo de pessoa como pessoa física
        } else if (pessoaJuridicaRadioButton.isSelected()) {
            tipoPessoa = "Pessoa Jurídica"; // Define o tipo de pessoa como pessoa jurídica
        }

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || tipoPessoa == null) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos e selecione o tipo de pessoa.",
                    "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro se algum campo estiver vazio
            return;
        }

        Cliente cliente = new Cliente(nome, endereco, telefone, tipoPessoa); // Cria um novo cliente
        cadastroCliente.adicionarCliente(cliente); // Adiciona o cliente ao cadastro
        adicionarNaTabela(cliente); // Adiciona o cliente à tabela
        limparCampos(); // Limpa os campos de entrada

        JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!"); // Exibe uma mensagem de sucesso
    }

    private void removerCliente() {
        int selectedRow = clientesTable.getSelectedRow(); // Obtém a linha selecionada na tabela
        if (selectedRow != -1) {
            Cliente clienteRemover = cadastroCliente.getListaClientes().get(selectedRow); // Obtém o cliente a ser
                                                                                          // removido
            cadastroCliente.removerCliente(clienteRemover.getNome()); // Remove o cliente do cadastro
            atualizarTabela(); // Atualiza a tabela
            limparCampos(); // Limpa os campos de entrada
            JOptionPane.showMessageDialog(this, "Cliente removido com sucesso!"); // Exibe uma mensagem de sucesso
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para remover.",
                    "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro se nenhum cliente estiver
                                                        // selecionado
        }
    }

    private void atualizarCliente() {
        int selectedRow = clientesTable.getSelectedRow(); // Obtém a linha selecionada na tabela
        if (selectedRow != -1) {
            String nomeAntigo = cadastroCliente.getListaClientes().get(selectedRow).getNome(); // Obtém o nome do
                                                                                               // cliente selecionado
            String nome = nomeTextField.getText(); // Obtém o novo nome do campo de texto
            String endereco = enderecoTextField.getText(); // Obtém o novo endereço do campo de texto
            String telefone = telefoneTextField.getText(); // Obtém o novo telefone do campo de texto
            String tipoPessoa = pessoaFisicaRadioButton.isSelected() ? "Pessoa Física" : "Pessoa Jurídica"; // Obtém o
                                                                                                            // novo tipo
                                                                                                            // de pessoa

            Cliente clienteAtualizado = new Cliente(nome, endereco, telefone, tipoPessoa); // Cria um novo cliente
                                                                                           // atualizado
            if (cadastroCliente.atualizarCliente(nomeAntigo, clienteAtualizado)) { // Atualiza o cliente no cadastro
                atualizarTabela(); // Atualiza a tabela
                JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!"); // Exibe uma mensagem de sucesso
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar cliente.",
                        "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro se ocorrer algum problema na
                                                            // atualização
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.",
                    "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro se nenhum cliente estiver
                                                        // selecionado
        }
    }

    private void voltarParaTelaPrincipal() {
        setVisible(false); // Torna a janela atual invisível
        dispose(); // Libera os recursos da janela atual
        // Chamar a tela principal ou outra tela desejada
    }

    private void adicionarNaTabela(Cliente cliente) {
        tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(),
                cliente.getTelefone(), cliente.getTipoPessoa() }); // Adiciona uma nova linha à tabela com os dados do
                                                                   // cliente
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Cliente cliente : cadastroCliente.getListaClientes()) {
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(),
                    cliente.getTelefone(), cliente.getTipoPessoa() }); // Adiciona uma nova linha à tabela com os dados
                                                                       // de cada cliente
        }
    }

    private void preencherCampos(Cliente cliente) {
        nomeTextField.setText(cliente.getNome()); // Preenche o campo de nome com o nome do cliente
        enderecoTextField.setText(cliente.getEndereco()); // Preenche o campo de endereço com o endereço do cliente
        telefoneTextField.setText(cliente.getTelefone()); // Preenche o campo de telefone com o telefone do cliente
        if (cliente.getTipoPessoa().equals("Pessoa Física")) {
            pessoaFisicaRadioButton.setSelected(true); // Seleciona o botão de rádio para pessoa física
        } else if (cliente.getTipoPessoa().equals("Pessoa Jurídica")) {
            pessoaJuridicaRadioButton.setSelected(true); // Seleciona o botão de rádio para pessoa jurídica
        }
    }

    private void limparCampos() {
        nomeTextField.setText(""); // Limpa o campo de nome
        enderecoTextField.setText(""); // Limpa o campo de endereço
        telefoneTextField.setText(""); // Limpa o campo de telefone
        tipoPessoaButtonGroup.clearSelection(); // Limpa a seleção dos botões de rádio
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroCliente(); // Cria uma nova instância da classe TelaCadastroCliente
            }
        });
    }
}
