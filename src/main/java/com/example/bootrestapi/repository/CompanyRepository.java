package com.example.bootrestapi.repository;

import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query("select t from Company t")
     List<CompanyResponse> getAllCompany();

    @Query("select c from Company c where c.id=:id")
    CompanyResponse getCompanyById(Long id);
}
