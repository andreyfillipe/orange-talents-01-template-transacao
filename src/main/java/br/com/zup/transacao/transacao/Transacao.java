package br.com.zup.transacao.transacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String transacaoId;
    @NotNull
    @Column(nullable = false)
    private BigDecimal valor;
    @NotNull
    @Embedded
    private Estabelecimento estabelecimento;
    @NotNull
    @Embedded
    private Cartao cartao;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String transacaoId, @NotNull BigDecimal valor, @NotNull Estabelecimento estabelecimento, @NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
        this.transacaoId = transacaoId;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
