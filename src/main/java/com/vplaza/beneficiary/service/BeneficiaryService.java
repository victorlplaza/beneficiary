package com.vplaza.beneficiary.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vplaza.beneficiary.entity.Beneficiary;
import com.vplaza.beneficiary.entity.Document;
import com.vplaza.beneficiary.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    public Beneficiary create(Beneficiary obj) {
        if (obj.getDocument() != null) {
            for (Document document : obj.getDocument()) {
                document.setBeneficiary(obj);
            }
        }
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Beneficiary getId(Long id) {
        Optional<Beneficiary> obj = repository.findById(id);
        return obj.get();
    }

    public List<Beneficiary> getAll() {
        return repository.findAll();
    }

    public Beneficiary update(Beneficiary obj) {
        Optional<Beneficiary> newObj = repository.findById(obj.getId());
        updateBeneficiary(newObj, obj);
        return repository.save(newObj.get());

    }

    private void updateBeneficiary(Optional<Beneficiary> newObj, Beneficiary obj) {
        newObj.get().setName(obj.getName());
        newObj.get().setTelephone(obj.getTelephone());
        newObj.get().setDateBirth(obj.getDateBirth());
        newObj.get().setDateUpdate(LocalDateTime.now());
    }

}
