package com.vplaza.beneficiary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vplaza.beneficiary.entity.BeneficiaryDTO;
import com.vplaza.beneficiary.repository.BeneficiaryRepositoryDTO;

@Service
public class BeneficiaryServiceDTO {

    @Autowired
    private BeneficiaryRepositoryDTO repository;

    public List<BeneficiaryDTO> getAll() {
        return repository.findAll();
    }

}
