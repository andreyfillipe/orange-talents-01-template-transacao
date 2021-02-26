package br.com.zup.transacao.transacao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Cartao {

    @NotBlank
    @Column(nullable = false)
    private String cartaoId;
    @NotBlank
    @Column(nullable = false)
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank String cartaoId, @NotBlank String email) {
        this.cartaoId = cartaoId;
        this.email = email;
    }

    public CartaoResponse toCartaoResponse() {
        return new CartaoResponse(this.cartaoId, this.email);
    }
}
