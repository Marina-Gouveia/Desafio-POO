
import java.util.List;

public class Turma {
    private String nome;
    private String horario;
    private String dataInicio;
    private int nMinimoAlunos;
    private List<Aluno> alunos;

    public Turma(String nome, String horario, String dataInicio, int nMinimoAlunos, List<Aluno> alunos) {
        this.nome = nome;
        this.horario = horario;
        this.dataInicio = dataInicio;
        this.nMinimoAlunos = nMinimoAlunos;
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void pushAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public int getnMinimoAlunos() {
        return nMinimoAlunos;
    }

    public void setnMinimoAlunos(int nMinimoAlunos) {
        this.nMinimoAlunos = nMinimoAlunos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
