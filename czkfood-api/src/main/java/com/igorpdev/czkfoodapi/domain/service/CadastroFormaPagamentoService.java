package com.igorpdev.czkfoodapi.domain.service;

import javax.transaction.Transactional;

import com.igorpdev.czkfoodapi.domain.exception.EntidadeEmUsoException;
import com.igorpdev.czkfoodapi.domain.exception.FormaPagamentoNaoEncontradaException;
import com.igorpdev.czkfoodapi.domain.model.FormaPagamento;
import com.igorpdev.czkfoodapi.domain.repository.FormaPagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroFormaPagamentoService {
    
    private static final String MSG_FORMA_PAGAMENTO_EM_USO 
    = "Forma de pagamento de código %d não pode ser removida, pois está em uso";

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    public FormaPagamento buscarOuFalhar(Long formaPagamentoId) {
        return formaPagamentoRepository.findById(formaPagamentoId)
            .orElseThrow(() -> new FormaPagamentoNaoEncontradaException(formaPagamentoId));
    }

    @Transactional
    public void excluir(Long formaPagamentoId) {
        try {
            formaPagamentoRepository.deleteById(formaPagamentoId);
            formaPagamentoRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new FormaPagamentoNaoEncontradaException(formaPagamentoId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                String.format(MSG_FORMA_PAGAMENTO_EM_USO, formaPagamentoId));
        }
    }

}
