package org.acme;

public class Erro {
    private String mensagem;
    private Aluno alunoInvalido;

    public Erro(String mensagem, Aluno alunoInvalido) {
        this.mensagem = mensagem;
        this.alunoInvalido = alunoInvalido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Aluno getAlunoInvalido() {
        return alunoInvalido;
    }

    public void setAlunoInvalido(Aluno alunoInvalido) {
        this.alunoInvalido = alunoInvalido;
    }
}
