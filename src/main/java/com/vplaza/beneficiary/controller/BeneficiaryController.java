package com.vplaza.beneficiary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vplaza.beneficiary.entity.Beneficiary;
import com.vplaza.beneficiary.service.BeneficiaryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/beneficiary")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @Operation(summary = "Add the new beneficiary and their documents in the database.", description = "This endpoint receive a Beneficiary and Document object and salve this infomation in the database. Case the beneficiary was success created the response was HTTP STATUS 201. If an error occurs the response will be HTTS Status Error.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Information created successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<Beneficiary> create(@RequestBody Beneficiary obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @Operation(summary = "Delete a beneficiary and their documents in the database.", description = "This endpoint receive Beneficiary ID with paramenter in URL and delete this Beneficiary and their Documents. Case the informations was deleted successfully the response was HTTP STATUS 201. If an error occurs the response will be HTTS Status Error.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Information deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Information");
    }

    @Operation(summary = "Obtain beneficiary information by ID, including their documents, if you have registered documents in the database.", description = "This endpoint receive Beneficiary ID with paramenter in URL and show Beneficiary and their Documents information. Case the ID exist in the database the response was HTTP STATUS 201. If an error occurs the response will be HTTS Status Error.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Informations displayed successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Beneficiary> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }

    @Operation(summary = "Obtain all beneficiaries informations by ID, including their documents, if you have registered documents in the database.", description = "This endpoint show all Beneficiary and their Documents information. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Informations displayed successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<List<Beneficiary>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @Operation(summary = "Edit beneficiaries informations by ID, this is not including their documents.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Information created successfully"),
            @ApiResponse(responseCode = "400", description = "Validantion Error"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Beneficiary> update(@PathVariable Long id, @RequestBody Beneficiary obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

}
