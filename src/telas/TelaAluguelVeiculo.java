/**
 * Classe responsável por exibir a tela de aluguel de veículo.
 * Permite ao usuário selecionar um cliente, um veículo, inserir as datas de início e fim do aluguel,
 * exibir o valor da diária do veículo selecionado e o valor total do aluguel.
 * Também permite confirmar o aluguel e voltar à tela principal.
 */
package telas;


import javax.swing.*; // Importação da biblioteca Swing para criação da interface gráfica
import java.awt.*; // Importação da biblioteca AWT para manipulação de componentes gráficos
import java.awt.event.*; // Importação da biblioteca AWT para manipulação de eventos
import cadastro.CadastroCliente; // Importação da classe CadastroCliente do pacote cadastro
import cadastro.CadastroVeiculo; // Importação da classe CadastroVeiculo do pacote cadastro
import modelo.Cliente; // Importação da classe Cliente do pacote modelo
import modelo.Veiculo; // Importação da classe Veiculo do pacote modelo
import java.time.LocalDate; // Importação da classe LocalDate da biblioteca java.time para manipulação de datas
import java.time.format.DateTimeParseException; // Importação da classe DateTimeParseException da biblioteca java.time.format para tratamento de exceções relacionadas a formatação de datas
import java.time.temporal.ChronoUnit; // Importação da classe ChronoUnit da biblioteca java.time.temporal para cálculos com datas



public class TelaAluguelVeiculo extends JFrame { 

    private JComboBox<Cliente> pessoaComboBox; // ComboBox para seleção de cliente
    private JComboBox<Veiculo> veiculoComboBox; // ComboBox para seleção de veículo
    private JTextField dataInicioTextField; // Campo de texto para inserção da data de início do aluguel
    private JTextField dataFimTextField; // Campo de texto para inserção da data de fim do aluguel
    private JTextField valorDiariaTextField; // Campo de texto para exibição do valor da diária do veículo selecionado
    private JTextField valorTextField; // Campo de texto para exibição do valor total do aluguel
    private JButton confirmarButton; // Botão para confirmar o aluguel
    private JButton voltarButton; // Botão para voltar à tela principal
    private CadastroCliente cadastroCliente; // Instância da classe CadastroCliente para manipulação dos clientes
    private CadastroVeiculo cadastroVeiculo; // Instância da classe CadastroVeiculo para manipulação dos veículos

    public TelaAluguelVeiculo() { 

        cadastroCliente = new CadastroCliente(); // Instanciação do objeto cadastroCliente
        cadastroVeiculo = new CadastroVeiculo(); // Instanciação do objeto cadastroVeiculo

        setTitle("Aluguel de Veículo"); // Define o título da janela
        setSize(400, 350); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o comportamento padrão ao fechar a janela
        setLocationRelativeTo(null); // Define a posição da janela como centralizada na tela

        JPanel mainPanel = new JPanel(); // Criação do painel principal
        mainPanel.setLayout(new GridLayout(7, 2, 0, 6)); // Define o layout do painel principal como uma grade com 7 linhas, 2 colunas e espaçamento entre os componentes
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Define uma borda vazia para o painel principal

        Font font = new Font("Arial", Font.PLAIN, 12); // Define a fonte a ser utilizada nos componentes gráficos

        JLabel pessoaLabel = new JLabel("Pessoa:"); // Criação do rótulo "Pessoa"
        pessoaLabel.setFont(font); // Define a fonte do rótulo
        pessoaComboBox = new JComboBox<>(); // Criação do ComboBox para seleção de cliente
        popularComboBoxClientes(); // Preenche o combo box de clientes
        mainPanel.add(pessoaLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(pessoaComboBox); // Adiciona o ComboBox ao painel principal

        JLabel veiculoLabel = new JLabel("Veículo:"); // Criação do rótulo "Veículo"
        veiculoLabel.setFont(font); // Define a fonte do rótulo
        veiculoComboBox = new JComboBox<>(); // Criação do ComboBox para seleção de veículo
        popularComboBoxVeiculos(); // Preenche o combo box de veículos
        veiculoComboBox.addActionListener(new ActionListener() { // Adiciona um ouvinte de eventos ao ComboBox de veículos
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDiariaVeiculoSelecionado(); // Chama o método para exibir o valor da diária do veículo selecionado
            }
        });
        mainPanel.add(veiculoLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(veiculoComboBox); // Adiciona o ComboBox ao painel principal

        JLabel dataInicioLabel = new JLabel("Data de Início:"); // Criação do rótulo "Data de Início"
        dataInicioTextField = new JTextField(); // Criação do campo de texto para inserção da data de início
        mainPanel.add(dataInicioLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(dataInicioTextField); // Adiciona o campo de texto ao painel principal

        JLabel dataFimLabel = new JLabel("Data de Fim:"); // Criação do rótulo "Data de Fim"
        dataFimTextField = new JTextField(); // Criação do campo de texto para inserção da data de fim
        mainPanel.add(dataFimLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(dataFimTextField); // Adiciona o campo de texto ao painel principal

        JLabel valorDiariaLabel = new JLabel("Valor Diária:"); // Criação do rótulo "Valor Diária"
        valorDiariaTextField = new JTextField(); // Criação do campo de texto para exibição do valor da diária
        valorDiariaTextField.setEditable(false); // Define o campo de texto como somente leitura
        mainPanel.add(valorDiariaLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(valorDiariaTextField); // Adiciona o campo de texto ao painel principal

        JLabel valorLabel = new JLabel("Valor Total:"); // Criação do rótulo "Valor Total"
        valorTextField = new JTextField(); // Criação do campo de texto para exibição do valor total
        valorTextField.setEditable(false); // Define o campo de texto como somente leitura
        mainPanel.add(valorLabel); // Adiciona o rótulo ao painel principal
        mainPanel.add(valorTextField); // Adiciona o campo de texto ao painel principal

        confirmarButton = new JButton("Confirmar Aluguel"); // Criação do botão "Confirmar Aluguel"
        confirmarButton.setFont(font); // Define a fonte do botão
        confirmarButton.addActionListener(new ActionListener() { // Adiciona um ouvinte de eventos ao botão "Confirmar Aluguel"
            @Override
            public void actionPerformed(ActionEvent e) {
                alugarVeiculo(); // Chama o método para realizar o aluguel do veículo
            }
        });
        mainPanel.add(confirmarButton); // Adiciona o botão ao painel principal

        voltarButton = new JButton("Voltar"); // Criação do botão "Voltar"
        voltarButton.setFont(font); // Define a fonte do botão
        voltarButton.addActionListener(new ActionListener() { // Adiciona um ouvinte de eventos ao botão "Voltar"
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Oculta a janela atual
                dispose(); // Libera os recursos utilizados pela janela atual
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Criação de uma instância da classe TelaPrincipal
                telaPrincipal.setVisible(true); // Exibe a tela principal
            }
        });
        mainPanel.add(voltarButton); // Adiciona o botão ao painel principal

        add(mainPanel); // Adiciona o painel principal à janela
        setVisible(true); // Exibe a janela
    }

    private void alugarVeiculo() { // Método para realizar o aluguel do veículo
        Cliente clienteSelecionado = (Cliente) pessoaComboBox.getSelectedItem(); // Obtém o cliente selecionado no ComboBox
        Veiculo veiculoSelecionado = (Veiculo) veiculoComboBox.getSelectedItem(); // Obtém o veículo selecionado no ComboBox
        String dataInicioStr = dataInicioTextField.getText(); // Obtém a data de início do aluguel
        String dataFimStr = dataFimTextField.getText(); // Obtém a data de fim do aluguel

        if (clienteSelecionado == null || veiculoSelecionado == null || dataInicioStr.isEmpty() || dataFimStr.isEmpty()) { // Verifica se todos os campos foram preenchidos
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro
            return; // Retorna sem realizar o aluguel
        }

        LocalDate dataInicio; // Variável para armazenar a data de início
        LocalDate dataFim; // Variável para armazenar a data de fim

        try {
            dataInicio = LocalDate.parse(dataInicioStr); // Converte a string da data de início para o formato LocalDate
            dataFim = LocalDate.parse(dataFimStr); // Converte a string da data de fim para o formato LocalDate
        } catch (DateTimeParseException ex) { // Trata a exceção caso a formatação da data seja inválida
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro
            return; // Retorna sem realizar o aluguel
        }

        long diasAluguel = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1; // Calcula o número de dias de aluguel, incluindo o último dia

        if (diasAluguel <= 0) { // Verifica se o número de dias de aluguel é válido
            JOptionPane.showMessageDialog(this, "Data de fim deve ser posterior à data de início.", "Erro", JOptionPane.ERROR_MESSAGE); // Exibe uma mensagem de erro
            return; // Retorna sem realizar o aluguel
        }

        double valorTotal = diasAluguel * veiculoSelecionado.getValorDiaria(); // Calcula o valor total do aluguel

        valorDiariaTextField.setText(String.format("R$ %.2f", veiculoSelecionado.getValorDiaria())); // Atualiza o campo de texto com o valor da diária
        valorTextField.setText(String.format("R$ %.2f", valorTotal)); // Atualiza o campo de texto com o valor total

        JOptionPane.showMessageDialog(this, String.format("Aluguel confirmado com sucesso!\n\n" +
                "Veículo: %s\n" +
                "Valor da Diária: R$ %.2f\n" +
                "Número de Dias: %d\n" +
                "Valor Total: R$ %.2f",
                veiculoSelecionado.getModelo(), veiculoSelecionado.getValorDiaria(), diasAluguel, valorTotal)); // Exibe uma mensagem de confirmação do aluguel
    }

    private void popularComboBoxClientes() { // Método para preencher o ComboBox de clientes
        for (Cliente cliente : cadastroCliente.getClientes()) { // Percorre a lista de clientes do cadastro
            pessoaComboBox.addItem(cliente); // Adiciona cada cliente ao ComboBox
        }
    }

    private void popularComboBoxVeiculos() { // Método para preencher o ComboBox de veículos
        for (Veiculo veiculo : cadastroVeiculo.getVeiculos()) { // Percorre a lista de veículos do cadastro
            veiculoComboBox.addItem(veiculo); // Adiciona cada veículo ao ComboBox
        }
    }

    private void mostrarDiariaVeiculoSelecionado() { // Método para exibir o valor da diária do veículo selecionado
        Veiculo veiculoSelecionado = (Veiculo) veiculoComboBox.getSelectedItem(); // Obtém o veículo selecionado no ComboBox
        if (veiculoSelecionado != null) { // Verifica se um veículo foi selecionado
            valorDiariaTextField.setText(String.format("R$ %.2f", veiculoSelecionado.getValorDiaria())); // Atualiza o campo de texto com o valor da diária
        }
    }

    public static void main(String[] args) { // Método principal
        SwingUtilities.invokeLater(new Runnable() { // Criação de uma nova thread para execução da interface gráfica
            @Override
            public void run() {
                new TelaAluguelVeiculo(); // Criação de uma instância da classe TelaAluguelVeiculo
            }
        });
    }
}
