package com.igorpdev.czkfoodapi.domain.service;

import java.util.List;

import com.igorpdev.czkfoodapi.domain.filter.VendaDiariaFilter;
import com.igorpdev.czkfoodapi.domain.model.dto.VendaDiaria;

public interface VendaQueryService {
    
    List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String timeOffset);

}
