package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ApplicationScoped
public class AlunoConsumer {
    @Inject
    AlunoProducer producer;

    @Incoming("aluno")
    public void consume(Aluno aluno) {

        // Validação dos dados
        if (!dadosSaoValidos(aluno)) {
            // Dados inválidos, gerar evento de erro
            Erro erro = new Erro("Dados invalidos para o aluno: " + aluno.getNome(), aluno);
            producer.sendErro(erro);
            return;
        }

        // Cálculo da média
        double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4.0;

        // Arredonda a média para duas casas decimais
        BigDecimal bd = new BigDecimal(Double.toString(media));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        media = bd.doubleValue();

        aluno.setMedia(media);

        // Verifica se o aluno foi aprovado ou reprovado
        if (media >= 7.0) {
            producer.sendAprovado(aluno);
        } else {
            producer.sendReprovado(aluno);
        }
    }

    private boolean dadosSaoValidos(Aluno aluno) {
        // Validação do nome
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            return false; // Nome não pode ser vazio ou nulo
        }

        // Validação da matéria
        if (aluno.getMateria() == null || aluno.getMateria().isEmpty()) {
            return false; // Matéria não pode ser vazia ou nula
        }

        // Validação das notas
        if (aluno.getNota1() == null || aluno.getNota1() < 0 || aluno.getNota1() > 10) {
            return false; // Nota1 deve estar entre 0 e 10
        }
        if (aluno.getNota2() == null || aluno.getNota2() < 0 || aluno.getNota2() > 10) {
            return false; // Nota2 deve estar entre 0 e 10
        }
        if (aluno.getNota3() == null || aluno.getNota3() < 0 || aluno.getNota3() > 10) {
            return false; // Nota3 deve estar entre 0 e 10
        }
        if (aluno.getNota4() == null || aluno.getNota4() < 0 || aluno.getNota4() > 10) {
            return false; // Nota4 deve estar entre 0 e 10
        }

        // Verifica se a média já foi preenchida
        if (aluno.getMedia() != null) {
            return false; // Média já foi preenchida
        }

        // Dados válidos
        return true;
    }
}
