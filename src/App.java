import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
        atendentes.add(new Atendente("Atendente de teste"));
        Empresa empresa = new Empresa("Empresa de teste", atendentes);

        ArrayList<Curso> cursos = new ArrayList<Curso>();

        // ====== Curso 1 =======
            ArrayList<Turma> turmas = new ArrayList<Turma>();
            ArrayList<Aluno> alunos = new ArrayList<Aluno>();
            alunos.add(new Aluno("Fulano da silva", "11122233399"));
            turmas.add(new Turma("Eng-1", "Manhã", "10 de janeiro de 2022", 3, alunos));
            alunos = new ArrayList<Aluno>();
            turmas.add(new Turma("Eng-2", "Tarde", "12 de janeiro de 2022", 4, alunos));
            turmas.add(new Turma("Eng-3", "Noite", "15 de janeiro de 2022", 7, alunos));
            Curso curso1 = new Curso("Eng. civil", turmas);
            cursos.add(curso1);
        // ====== fim Curso 1 =======

        // ====== Curso 2 =======
            turmas = new ArrayList<Turma>();
            alunos = new ArrayList<Aluno>();
            turmas.add(new Turma("Enf-1", "Tarde", "12 de janeiro de 2022", 10, alunos));
            turmas.add(new Turma("Enf-2", "Noite", "15 de janeiro de 2022", 12, alunos));
            Curso curso2 = new Curso("Enfermagem", turmas);
            cursos.add(curso2);
        // ====== fim Curso 2 =======

        // ====== Curso 2 =======
            turmas = new ArrayList<Turma>();
            alunos = new ArrayList<Aluno>();
            turmas.add(new Turma("CCO-1", "Noite", "15 de janeiro de 2022", 5, alunos));
            Curso curso3 = new Curso("Ciências da computação", turmas);
            cursos.add(curso3);
        // ====== fim Curso 2 =======
        System.out.println("Olá visitante!");
        System.out.println("Seja bem-vindo à "+empresa.getNome());
        Random rand = new Random();
        int indexAtendenteDaVez = rand.nextInt(empresa.getAtendentes().size());

        System.out.println("Menu nome é "+empresa.getAtendentes().get(indexAtendenteDaVez).getNome()+" e eu vou dar prosseguimento ao seu atendimento.");

        System.out.println("========================");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i+1)+" - "+cursos.get(i).getNome());
        }
        System.out.println("========================");

        System.out.println("Digite o número correspondente ao curso para saber quais turmas estão disponíveis:");
        Scanner n1 = new Scanner(System.in);
        
        if(n1.hasNextInt()) {
            int nCurso = n1.nextInt();
            if(nCurso > cursos.size()) {
                System.out.println("Você digitou um número inválido!");
                System.out.println("Tente novamente.");
            } else {
                Curso cursoSelecionado = cursos.get(nCurso-1);
                if(cursoSelecionado.getTurmas().size() == 0) {
                    System.out.println("Este curso não tem nenhuma turma disponível no momento!");
                    System.out.println("Tente outro curso.");
                } else {
                    for (int i = 0; i < cursoSelecionado.getTurmas().size(); i++) {
                        Turma turma = cursoSelecionado.getTurmas().get(i);
                        System.out.println("==== Turma "+turma.getNome()+" ====");
                        System.out.println("Horário das aulas: "+turma.getHorario());
                        System.out.println("Data de início: "+turma.getDataInicio());
                        System.out.println("Mínimo de alunos para início: "+turma.getnMinimoAlunos());
                        System.out.println("");
                    }

                    System.out.println("==========================================================");
                    System.out.println("Você gostaria de se matricular em alguma das turmas acima?");
                    System.out.println("==========================================================");
                    System.out.println("Digite 1 para sim ou 2 para nao:");

                    Scanner n2 = new Scanner(System.in);
                    if(n2.hasNextInt()) {
                        int resposta = n2.nextInt();
                        if(resposta == 1) {
                            System.out.println("Digite o nome da turma:");
                            Scanner n3 = new Scanner(System.in);
                            if(n3.hasNext()) {
                                String turmaNome = n3.next();
                                Boolean turmaNomeEstaCorreto = false;
                                int indexTurmaSelecionada = 0;
                                for (int i = 0; i < cursoSelecionado.getTurmas().size(); i++) {
                                    Turma turma = cursoSelecionado.getTurmas().get(i);
                                    
                                    if(turma.getNome().equals(turmaNome)) {
                                        System.out.println("entrou");
                                        turmaNomeEstaCorreto = true;
                                        indexTurmaSelecionada = i;
                                    }
                                }

                                if(turmaNomeEstaCorreto == false) {
                                    System.out.println("Não encontramos nenhuma turma com esse nome, tente novamente!");
                                } else {
                                    System.out.println("Digite seu CPF (apenas números):");
                                    Scanner n4 = new Scanner(System.in);
                                    if(n4.hasNext()) {
                                        String cpfAluno = n4.next();
                                        String nomeAluno = "";
                                        Boolean isCadastradoNesteCurso = false;
                                        Turma turmaSelecionada = cursoSelecionado.getTurmas().get(indexTurmaSelecionada);
                                        for (int i = 0; i < turmaSelecionada.getAlunos().size(); i++) {
                                            Aluno aluno = turmaSelecionada.getAlunos().get(i);
                                            if(aluno.getCpf().equals(cpfAluno)) {
                                                isCadastradoNesteCurso = true;
                                                nomeAluno = aluno.getNome();
                                            }
                                        }

                                        if(isCadastradoNesteCurso == true) {
                                            System.out.println("Ooops, Você já está cadastrado nesta turma!");
                                        } else {

                                            if(isCadastradoNesteCurso == false) {
                                                for (int i = 0; i < cursos.size(); i++) {
                                                    for (int j = 0; j < cursos.get(i).getTurmas().size(); j++) {
                                                        List<Aluno> a = cursos.get(i).getTurmas().get(j).getAlunos();
                                                        for (int k = 0; k < a.size(); k++) {
                                                            Aluno aluno = a.get(k);
                                                            if(aluno.getCpf().equals(cpfAluno)) {
                                                                nomeAluno = aluno.getNome();
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            if(nomeAluno == "") {
                                                System.out.println("Para finalizar, digite seu nome completo");
                                                Scanner n5 = new Scanner(System.in);
                                                if(n5.hasNext()) {
                                                    nomeAluno = n5.next();
                                                    Aluno aluno = new Aluno(nomeAluno, cpfAluno);
                                                    turmaSelecionada.pushAluno(aluno);
                                                    System.out.println("=====================================================");
                                                    System.out.println("Parabens "+nomeAluno.split(" ")[0]+", você agora esta matriculado na turma "+turmaSelecionada.getNome()+" do curso "+cursoSelecionado.getNome());
                                                    System.out.println("=====================================================");
                                                }
                                                n5.close();
                                            } else {
                                                Aluno aluno = new Aluno(nomeAluno, cpfAluno);
                                                turmaSelecionada.pushAluno(aluno);
                                                System.out.println("=====================================================");
                                                System.out.println("Parabens "+nomeAluno.split(" ")[0]+", você agora está matriculado na turma "+turmaSelecionada.getNome()+" do curso "+cursoSelecionado.getNome());
                                                System.out.println("=====================================================");
                                            }
                                        }
                                    }
                                    n4.close();
                                }
                            }
                            n3.close();
                        } else if(resposta == 2) {
                            System.out.println("Certo, até mais :)");
                        } else {
                            System.out.println("Você digitou uma opção inválida!");
                        }
                    } else {
                        System.out.println("Você digitou uma opção inválida!");
                    }
                    n2.close();
                }
            }
        } else {
            System.out.println("Você digitou um caracter inválido!");
            System.out.println("Tente novamente.");
        }
        n1.close();
    }
}
