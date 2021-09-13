package com.igorpdev.czkfoodapi.infrastructure.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.igorpdev.czkfoodapi.domain.filter.VendaDiariaFilter;
import com.igorpdev.czkfoodapi.domain.model.Pedido;
import com.igorpdev.czkfoodapi.domain.model.dto.VendaDiaria;
import com.igorpdev.czkfoodapi.domain.service.VendaQueryService;

import org.springframework.stereotype.Repository;

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro) {
        var builder = entityManager.getCriteriaBuilder();
        var query = builder.createQuery(VendaDiaria.class);
        var root = query.from(Pedido.class);

        var functionDateDataCriacao = builder.function("date", Date.class, root.get("dataCriacao"));

        var selection = builder.construct(VendaDiaria.class, 
            functionDateDataCriacao, 
            builder.count(root.get("id")),
            builder.sum(root.get("valorTotal")));

        query.select(selection);
        query.groupBy(functionDateDataCriacao);

        return entityManager.createQuery(query).getResultList();
    }
    
}
