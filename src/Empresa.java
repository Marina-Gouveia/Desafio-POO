import java.util.List;

public class Empresa {
    private String nome;
    private List<Atendente> atendentes;

    public Empresa(String nome, List<Atendente> atendentes) {
        this.nome = nome;
        this.atendentes = atendentes;
    }

    public List<Atendente> getAtendentes() {
        return atendentes;
    }

    public String getNome() {
        return nome;
    }
}
