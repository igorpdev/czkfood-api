package com.igorpdev.czkfoodapi.domain.service;

import com.igorpdev.czkfoodapi.domain.filter.VendaDiariaFilter;

public interface VendaReportService {

    byte[] emitirVendasDiarias(VendaDiariaFilter filtro, String timeOffset);

}
