package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SaleDto;
import com.devsuperior.dsvendas.dto.SaleSuccesDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDto> sellerList(Pageable pageable){
        sellerRepository.findAll();
        Page<Sale> saleList = repository.findAll(pageable);
        return saleList.map(x -> new SaleDto(x));
    }

    @Transactional
    public List<SaleSumDto> amountGroupedBySeller(){
        return repository.amountGroupedBySeller();
    }

    @Transactional
    public List<SaleSuccesDto> succesGroupedBySeller(){
        return repository.succesGroupedBySeller();
    }


}
