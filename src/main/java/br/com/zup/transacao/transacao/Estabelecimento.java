package br.com.zup.transacao.transacao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Estabelecimento {

    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotBlank
    @Column(nullable = false)
    private String cidade;
    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoResponse toEstabelecimentoResponse() {
        return new EstabelecimentoResponse(this.nome, this.cidade, this.endereco);
    }
}
