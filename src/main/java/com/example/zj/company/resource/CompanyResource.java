package com.example.zj.company.resource;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompanyResource implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String companyPhone;
    private String legalRepresentative;
    private String companyDescription;
}
