package com.bridge.resilience.bridgeresilience.service;

import com.bridge.resilience.bridgeresilience.model.PDFFile;
import com.bridge.resilience.bridgeresilience.repository.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    @Autowired
    private PdfRepository pdfRepository;

    public PdfService(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    public PDFFile getFile(String filename) {
        return pdfRepository.findByName(filename);
    }
}
