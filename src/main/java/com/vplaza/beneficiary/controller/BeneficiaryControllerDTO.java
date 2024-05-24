package com.vplaza.beneficiary.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vplaza.beneficiary.entity.BeneficiaryDTO;
import com.vplaza.beneficiary.service.BeneficiaryServiceDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/beneficiary")
public class BeneficiaryControllerDTO {

    @Autowired
    private BeneficiaryServiceDTO service;

    @Operation(summary = "Obtain all beneficiaries informations only, it´s not ncluding their documents.", description = "This endpoint show all Beneficiary information only. It does not contain documents information. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Informations displayed successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    @GetMapping("/only")
    public List<BeneficiaryDTO> getBeneficiaryBTO() {
        return service.getAll();
    }

}
