package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped

public class AlunoConsumer {
    @Inject
    AlunoProducer producer;
    @Incoming("aluno")
    public void consume(Aluno aluno) {

        System.out.println("Nome:" + aluno.getNome() );
        System.out.println("Materia:" + aluno.getMateria() );
        System.out.println("Notas:" + aluno.getNota1() + " " +
                aluno.getNota2()  + " " +
                aluno.getNota3()  + " " +
                aluno.getNota4());
        Double media = (aluno.getNota1()+aluno.getNota2()+ aluno.getNota3()+aluno.getNota4())/4;
        aluno.setMedia(media);
        producer.sendMedia(aluno);
    }
}
