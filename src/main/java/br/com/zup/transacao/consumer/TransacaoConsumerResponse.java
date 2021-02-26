package br.com.zup.transacao.consumer;

import br.com.zup.transacao.transacao.Transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoConsumerResponse {

    @NotBlank
    private String id;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private EstabelecimentoConsumerResponse estabelecimentoConsumerResponse;
    @NotNull
    private CartaoConsumerResponse cartaoConsumerResponse;
    @NotNull
    private LocalDateTime efetivadaEm;

    public TransacaoConsumerResponse(@NotBlank String id, @NotNull BigDecimal valor, @NotNull EstabelecimentoConsumerResponse estabelecimentoConsumerResponse, @NotNull CartaoConsumerResponse cartaoConsumerResponse, @NotNull LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimentoConsumerResponse = estabelecimentoConsumerResponse;
        this.cartaoConsumerResponse = cartaoConsumerResponse;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toTransacao() {
        return new Transacao(this.id, this.valor, this.estabelecimentoConsumerResponse.toEstabelecimento(), this.cartaoConsumerResponse.toCartao(), this.efetivadaEm);
    }
}
