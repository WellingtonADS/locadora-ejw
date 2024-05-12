package cadastro;

import java.util.ArrayList;
import java.util.List;
import modelo.Aluguel;

public class CadastroAluguel {

    private List<Aluguel> alugueis;

    public CadastroAluguel() {
        alugueis = new ArrayList<>();
    }

    public void adicionarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public void removerAluguel(Aluguel aluguel) {
        alugueis.remove(aluguel);
    }

    public void exibirAlugueis() {
        for (Aluguel aluguel : alugueis) {
            System.out.println(aluguel);
        }
    }

}
