 package org.acme;

 import org.eclipse.microprofile.reactive.messaging.Channel;
 import org.eclipse.microprofile.reactive.messaging.Emitter;

 import jakarta.enterprise.context.ApplicationScoped;
 import jakarta.inject.Inject;

 @ApplicationScoped
 public class AlunoProducer {

     @Inject
     @Channel("aluno-media")
     Emitter<Aluno> emitter;

    public void sendMedia(Aluno aluno) {
     emitter.send(aluno);
   }
}
