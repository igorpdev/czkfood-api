package com.igorpdev.czkfoodapi.infrastructure.service.report;

import org.springframework.stereotype.Service;

import com.igorpdev.czkfoodapi.domain.filter.VendaDiariaFilter;
import com.igorpdev.czkfoodapi.domain.service.VendaReportService;

@Service
public class PdfVendaReportService implements VendaReportService {

    @Override
    public byte[] emitirVendasDiarias(VendaDiariaFilter filtro, String timeOffset) {
        return null;
    }
    
}