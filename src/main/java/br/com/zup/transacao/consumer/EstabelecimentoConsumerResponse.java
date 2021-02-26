package br.com.zup.transacao.consumer;

import br.com.zup.transacao.transacao.Estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoConsumerResponse {

    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String endereco;

    public EstabelecimentoConsumerResponse(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
