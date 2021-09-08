package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDto> sellerList(){
        List<Seller> sellerList = repository.findAll();
        return sellerList.stream().map(x -> new SellerDto(x)).collect(Collectors.toList());
    }
}
