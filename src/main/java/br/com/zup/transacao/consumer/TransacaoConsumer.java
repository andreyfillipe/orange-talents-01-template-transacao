package br.com.zup.transacao.consumer;

import br.com.zup.transacao.transacao.Transacao;
import br.com.zup.transacao.transacao.TransacaoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransacaoConsumer {

    private TransacaoRepository transacaoRepository;

    public TransacaoConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void consume(TransacaoConsumerResponse response) {
        Transacao transacao = response.toTransacao();
        this.transacaoRepository.save(transacao);
    }
}
