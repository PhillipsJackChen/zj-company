package com.example.zj.company.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface CompanyRepository extends JpaRepository<Company, Serializable>, JpaSpecificationExecutor<Company> {
    @Query(value = "select * from company_info where id = ?1", nativeQuery = true)
    Company getCompanyById(Integer id);

    @Query(value = "select * from company_info limit 1", nativeQuery = true)
    Company getDefaultCompany();
}
