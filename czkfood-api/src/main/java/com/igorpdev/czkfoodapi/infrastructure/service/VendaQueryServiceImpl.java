package com.igorpdev.czkfoodapi.infrastructure.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import com.igorpdev.czkfoodapi.domain.filter.VendaDiariaFilter;
import com.igorpdev.czkfoodapi.domain.model.Pedido;
import com.igorpdev.czkfoodapi.domain.model.StatusPedido;
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
        var predicates = new ArrayList<Predicate>();

        var functionDateDataCriacao = builder.function("date", Date.class, root.get("dataCriacao"));

        var selection = builder.construct(VendaDiaria.class, 
            functionDateDataCriacao, 
            builder.count(root.get("id")),
            builder.sum(root.get("valorTotal")));

            if (filtro.getRestauranteId() != null) {
                predicates.add(builder.equal(root.get("restaurante"), filtro.getRestauranteId()));
            }
              
            if (filtro.getDataCriacaoInicio() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriacao"), 
                        filtro.getDataCriacaoInicio()));
            }
    
            if (filtro.getDataCriacaoFim() != null) {
                predicates.add(builder.lessThanOrEqualTo(root.get("dataCriacao"), 
                        filtro.getDataCriacaoFim()));
            }
              
            predicates.add(root.get("status").in(
                    StatusPedido.CONFIRMADO, StatusPedido.ENTREGUE));

        query.select(selection);
        query.where(predicates.toArray(new Predicate[0]));
        query.groupBy(functionDateDataCriacao);

        return entityManager.createQuery(query).getResultList();
    }
    
}