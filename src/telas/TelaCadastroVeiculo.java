/**
 * Classe responsável por exibir a tela de cadastro de veículos.
 * Permite ao usuário cadastrar, excluir, editar e visualizar os veículos cadastrados.
 */
package telas;

import cadastro.CadastroVeiculo;
import modelo.Veiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField modeloTextField; // Campo de texto para o modelo do veículo
    private JTextField marcaTextField; // Campo de texto para a marca do veículo
    private JTextField anoTextField; // Campo de texto para o ano do veículo
    private JTextField valorTextField; // Campo de texto para o valor da diária do veículo
    private CadastroVeiculo cadastroVeiculo; // Objeto responsável pelo cadastro de veículos
    private JTable veiculosTable; // Tabela para exibir os veículos cadastrados
    private DefaultTableModel tableModel; // Modelo da tabela
    private JButton cadastrarButton; // Botão para cadastrar um veículo
    private JButton excluirButton; // Botão para excluir um veículo
    private JButton editarButton; // Botão para editar um veículo
    private JButton voltarButton; // Botão para voltar à tela principal

    public TelaCadastroVeiculo() {
        cadastroVeiculo = new CadastroVeiculo(); // Inicializa o objeto de cadastro de veículos

        setTitle("Cadastro de Veículo"); // Define o título da janela
        setSize(400, 400); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel mainPanel = new JPanel(new BorderLayout()); // Painel principal
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Define uma borda vazia

        // Painel para os campos de entrada
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5)); // Painel com layout de grade
        Font font = new Font("Arial", Font.PLAIN, 12); // Define a fonte dos componentes

        JLabel modeloLabel = new JLabel("Modelo:"); // Rótulo para o campo de modelo
        modeloLabel.setFont(font); // Define a fonte do rótulo
        modeloTextField = new JTextField(); // Campo de texto para o modelo
        modeloTextField.setFont(font); // Define a fonte do campo de texto
        formPanel.add(modeloLabel); // Adiciona o rótulo ao painel
        formPanel.add(modeloTextField); // Adiciona o campo de texto ao painel

        JLabel marcaLabel = new JLabel("Marca:"); // Rótulo para o campo de marca
        marcaLabel.setFont(font); // Define a fonte do rótulo
        marcaTextField = new JTextField(); // Campo de texto para a marca
        marcaTextField.setFont(font); // Define a fonte do campo de texto
        formPanel.add(marcaLabel); // Adiciona o rótulo ao painel
        formPanel.add(marcaTextField); // Adiciona o campo de texto ao painel

        JLabel anoLabel = new JLabel("Ano:"); // Rótulo para o campo de ano
        anoLabel.setFont(font); // Define a fonte do rótulo
        anoTextField = new JTextField(); // Campo de texto para o ano
        anoTextField.setFont(font); // Define a fonte do campo de texto
        formPanel.add(anoLabel); // Adiciona o rótulo ao painel
        formPanel.add(anoTextField); // Adiciona o campo de texto ao painel

        JLabel valorLabel = new JLabel("Valor da Diária:"); // Rótulo para o campo de valor da diária
        valorLabel.setFont(font); // Define a fonte do rótulo
        valorTextField = new JTextField(); // Campo de texto para o valor da diária
        valorTextField.setFont(font); // Define a fonte do campo de texto
        formPanel.add(valorLabel); // Adiciona o rótulo ao painel
        formPanel.add(valorTextField); // Adiciona o campo de texto ao painel

        cadastrarButton = new JButton("Cadastrar"); // Botão para cadastrar um veículo
        cadastrarButton.setFont(font); // Define a fonte do botão
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarVeiculo(); // Chama o método para adicionar um veículo
            }
        });

        excluirButton = new JButton("Excluir"); // Botão para excluir um veículo
        excluirButton.setFont(font); // Define a fonte do botão
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirVeiculo(); // Chama o método para excluir um veículo
            }
        });

        editarButton = new JButton("Editar"); // Botão para editar um veículo
        editarButton.setFont(font); // Define a fonte do botão
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarVeiculo(); // Chama o método para editar um veículo
            }
        });

        voltarButton = new JButton("Voltar"); // Botão para voltar à tela principal
        voltarButton.setFont(font); // Define a fonte do botão
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Esconde a janela atual
                dispose(); // Libera os recursos da janela atual
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Cria uma nova instância da tela principal
                telaPrincipal.setVisible(true); // Exibe a tela principal
            }
        });

        formPanel.add(cadastrarButton); // Adiciona o botão de cadastrar ao painel
        formPanel.add(excluirButton); // Adiciona o botão de excluir ao painel
        formPanel.add(editarButton); // Adiciona o botão de editar ao painel
        formPanel.add(voltarButton); // Adiciona o botão de voltar ao painel

        mainPanel.add(formPanel, BorderLayout.NORTH); // Adiciona o painel de campos de entrada ao painel principal

        // Configuração da tabela de veículos
        String[] colunas = {"Modelo", "Marca", "Ano", "Valor Diária"}; // Nomes das colunas da tabela
        tableModel = new DefaultTableModel(colunas, 0); // Cria o modelo da tabela
        veiculosTable = new JTable(tableModel); // Cria a tabela com o modelo
        JScrollPane scrollPane = new JScrollPane(veiculosTable); // Painel de rolagem para a tabela
        mainPanel.add(scrollPane, BorderLayout.CENTER); // Adiciona o painel de rolagem ao painel principal

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

        add(mainPanel); // Adiciona o painel principal à janela
        setVisible(true); // Exibe a janela

        atualizarTabela(); // Atualiza a tabela de veículos
    }

    private void atualizarTabela() {
        List<Veiculo> listaVeiculos = cadastroVeiculo.getListaVeiculos(); // Obtém a lista de veículos do cadastro
        tableModel.setRowCount(0); // Limpa a tabela

        for (Veiculo veiculo : listaVeiculos) {
            Object[] rowData = {
                veiculo.getModelo(),
                veiculo.getMarca(),
                veiculo.getAno(),
                veiculo.getValorDiaria()
            };
            tableModel.addRow(rowData); // Adiciona uma linha à tabela com os dados do veículo
        }
    }

    private void adicionarVeiculo() {
        String modelo = modeloTextField.getText(); // Obtém o modelo do veículo
        String marca = marcaTextField.getText(); // Obtém a marca do veículo
        int ano;
        double valorDiaria;

        try {
            ano = Integer.parseInt(anoTextField.getText()); // Converte o ano para inteiro
            valorDiaria = Double.parseDouble(valorTextField.getText()); // Converte o valor da diária para double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor da Diária devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cadastroVeiculo.adicionarVeiculo(new Veiculo(modelo, marca, ano, valorDiaria)); // Adiciona o veículo ao cadastro
        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");

        limparCampos(); // Limpa os campos de entrada
        atualizarTabela(); // Atualiza a tabela de veículos
    }

    private void excluirVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow(); // Obtém a linha selecionada na tabela
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoRemover = cadastroVeiculo.getListaVeiculos().get(selectedRow); // Obtém o veículo a ser removido
        cadastroVeiculo.removerVeiculo(veiculoRemover.getModelo(), veiculoRemover.getMarca(), veiculoRemover.getAno(), veiculoRemover.getValorDiaria()); // Remove o veículo do cadastro

        limparCampos(); // Limpa os campos de entrada
        atualizarTabela(); // Atualiza a tabela de veículos
        JOptionPane.showMessageDialog(this, "Veículo removido com sucesso!");
    }

    private void editarVeiculo() {
        int selectedRow = veiculosTable.getSelectedRow(); // Obtém a linha selecionada na tabela
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um veículo na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String modelo = modeloTextField.getText(); // Obtém o modelo do veículo
        String marca = marcaTextField.getText(); // Obtém a marca do veículo
        int ano;
        double valorDiaria;

        try {
            ano = Integer.parseInt(anoTextField.getText()); // Converte o ano para inteiro
            valorDiaria = Double.parseDouble(valorTextField.getText()); // Converte o valor da diária para double
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e Valor da Diária devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.isEmpty() || marca.isEmpty() || anoTextField.getText().isEmpty() || valorTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veiculo veiculoAtualizado = new Veiculo(modelo, marca, ano, valorDiaria); // Cria um novo objeto Veiculo com os dados atualizados
        cadastroVeiculo.atualizarVeiculo(veiculoAtualizado); // Atualiza o veículo no cadastro

        limparCampos(); // Limpa os campos de entrada
        atualizarTabela(); // Atualiza a tabela de veículos
        JOptionPane.showMessageDialog(this, "Veículo atualizado com sucesso!");
    }

    private void preencherCampos(Veiculo veiculo) {
        modeloTextField.setText(veiculo.getModelo()); // Preenche o campo de modelo com o valor do veículo selecionado
        marcaTextField.setText(veiculo.getMarca()); // Preenche o campo de marca com o valor do veículo selecionado
        anoTextField.setText(String.valueOf(veiculo.getAno())); // Preenche o campo de ano com o valor do veículo selecionado
        valorTextField.setText(String.valueOf(veiculo.getValorDiaria())); // Preenche o campo de valor da diária com o valor do veículo selecionado
    }

    private void limparCampos() {
        modeloTextField.setText(""); // Limpa o campo de modelo
        marcaTextField.setText(""); // Limpa o campo de marca
        anoTextField.setText(""); // Limpa o campo de ano
        valorTextField.setText(""); // Limpa o campo de valor da diária
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroVeiculo(); // Cria uma nova instância da tela de cadastro de veículos
            }
        });
    }
}
