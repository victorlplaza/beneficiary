package com.vplaza.beneficiary.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeDocuments;
    private String description;
    private LocalDateTime dateAdd = LocalDateTime.now();
    private LocalDateTime dateUpdate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    @JsonBackReference // evitará a recursão infinita ao serializar/deserializar os objetos
    private Beneficiary beneficiary;

}
