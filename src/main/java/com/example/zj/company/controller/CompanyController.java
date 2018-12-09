package com.example.zj.company.controller;

import com.example.zj.company.domain.Company;
import com.example.zj.company.domain.CompanyRepository;
import com.example.zj.company.resource.CompanyResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/company/create")
    public String createCompanyInfo(@RequestBody CompanyResource companyResource, Model model) {
        Company company = new Company();
        company.setName(companyResource.getName());
        company.setAddress(companyResource.getAddress());
        company.setCompanyPhone(companyResource.getCompanyPhone());
        company.setCompanyDescription(companyResource.getCompanyDescription());
        company = companyRepository.save(company);
        model.addAttribute("company", company);
        return "company";
    }

    @PutMapping("/company/edit")
    public String editCompanyInfo(@RequestBody CompanyResource companyResource, Model model) {
        Company company = companyRepository.getCompanyById(companyResource.getId());
        company.setName(companyResource.getName());
        company.setAddress(companyResource.getAddress());
        company.setCompanyPhone(companyResource.getCompanyPhone());
        company.setCompanyDescription(companyResource.getCompanyDescription());
        company = companyRepository.save(company);
        model.addAttribute("company", company);
        return "company";
    }

    @GetMapping("/company/get")
    public String getCompanyInfo(Model model) {
        Company company = companyRepository.getDefaultCompany();
        model.addAttribute("company", company);
        return "company";
    }

    @GetMapping("/company/show")
    public String showCompany(Model model) {
        Company company = companyRepository.getDefaultCompany();
        model.addAttribute("company", company);
        return "index2";
    }

}
