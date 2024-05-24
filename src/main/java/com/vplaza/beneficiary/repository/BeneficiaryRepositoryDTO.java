package com.vplaza.beneficiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vplaza.beneficiary.entity.BeneficiaryDTO;

public interface BeneficiaryRepositoryDTO extends JpaRepository<BeneficiaryDTO, Long> {

}
