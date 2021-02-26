package br.com.zup.transacao.transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class TransacaoController {

    private TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}/transacoes")
    public ResponseEntity<List<TransacaoResponse>> filtrar(@PathVariable String id) {
        List<Transacao> transacoes = this.transacaoRepository.findTop10ByCartao_CartaoIdOrderByIdDesc(id);
        List<TransacaoResponse> responses = transacoes.stream().map(t -> new TransacaoResponse(t.getId(), t.getTransacaoId(), t.getValor(), t.getEstabelecimento().toEstabelecimentoResponse(), t.getCartao().toCartaoResponse(), t.getEfetivadaEm())).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
