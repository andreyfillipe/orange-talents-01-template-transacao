package br.com.zup.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;
    private String transacaoId;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimentoResponse;
    private CartaoResponse cartaoResponse;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Long id, String transacaoId, BigDecimal valor, EstabelecimentoResponse estabelecimentoResponse, CartaoResponse cartaoResponse, LocalDateTime efetivadaEm) {
        this.id = id;
        this.transacaoId = transacaoId;
        this.valor = valor;
        this.estabelecimentoResponse = estabelecimentoResponse;
        this.cartaoResponse = cartaoResponse;
        this.efetivadaEm = efetivadaEm;
    }
}
