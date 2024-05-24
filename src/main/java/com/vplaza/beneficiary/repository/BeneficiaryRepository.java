package com.vplaza.beneficiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vplaza.beneficiary.entity.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

}
