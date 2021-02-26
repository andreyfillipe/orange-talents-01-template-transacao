package br.com.zup.transacao.consumer;

import br.com.zup.transacao.transacao.Cartao;

import javax.validation.constraints.NotBlank;

public class CartaoConsumerResponse {

    @NotBlank
    private String id;
    @NotBlank
    private String email;

    public CartaoConsumerResponse(@NotBlank String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }
}
