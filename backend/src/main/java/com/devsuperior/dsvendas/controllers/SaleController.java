package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSuccesDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDto>> findSalesPaginate(Pageable pageable){
        Page<SaleDto> dtoSalesPaginate = saleService.sellerList(pageable);
        return ResponseEntity.ok(dtoSalesPaginate);
    }

    @GetMapping(path = "/amout-by-seller")
    public ResponseEntity<List<SaleSumDto>> amountGroupedBySeller(){
        List<SaleSumDto> saleSumDtosList = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(saleSumDtosList);
    }
    @GetMapping(path = "/succes-by-seller")
    public ResponseEntity<List<SaleSuccesDto>> succesGroupedBySeller(){
        List<SaleSuccesDto> saleSuccesDtosList = saleService.succesGroupedBySeller();
        return ResponseEntity.ok(saleSuccesDtosList);
    }


}
