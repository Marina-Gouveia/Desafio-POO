import java.util.List;

public class Curso {
    private String nome;
    private List<Turma> turmas;

    public Curso(String n, List<Turma> t) {
        this.nome = n;
        this.turmas = t;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
