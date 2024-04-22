package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlunoProducer {
    @Inject
    @Channel("aprovados")
    Emitter<Aluno> aprovadosEmitter;

    @Inject
    @Channel("reprovados")
    Emitter<Aluno> reprovadosEmitter;

    @Inject
    @Channel("erros")
    Emitter<Erro> errosEmitter;

    public void sendAprovado(Aluno aluno) {
        aprovadosEmitter.send(aluno);
    }

    public void sendReprovado(Aluno aluno) {
        reprovadosEmitter.send(aluno);
    }

    public void sendErro(Erro erro) {
        errosEmitter.send(erro);
    }

    public void sendErro(String mensagem, Aluno alunoInvalido) {
        Erro erro = new Erro(mensagem, alunoInvalido);
        errosEmitter.send(erro);
    }
}
