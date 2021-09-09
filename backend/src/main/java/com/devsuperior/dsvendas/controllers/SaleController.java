package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<SaleDto>> findSalesPaginate(Pageable pageable){
        sellerRepository.findAll();
        Page<SaleDto> dtoSalesPaginate = saleService.sellerList(pageable);
        return ResponseEntity.ok(dtoSalesPaginate);
    }
}
