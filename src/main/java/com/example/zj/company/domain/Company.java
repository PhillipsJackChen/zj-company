package com.example.zj.company.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company_info")
@Data
public class Company implements Serializable {
    private static final long serialVersionUID = 6868113957378345735L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COMPANY_PHONE")
    private String companyPhone;

    @Column(name = "LEGAL_REPRESENTATIVE")
    private String legalRepresentative;

    @Column(name = "COMPANY_DESCRIPTION")
    private String companyDescription;

}
