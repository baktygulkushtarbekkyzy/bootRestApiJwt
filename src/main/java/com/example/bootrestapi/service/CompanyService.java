package com.example.bootrestapi.service;

import com.example.bootrestapi.converter.companyConverter.CompanyConverterView;
import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface CompanyService {

    CompanyResponse saveCompany(CompanyRequest company) throws IOException;

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse getById(Long id);

    List<CompanyResponse> getAllCompany();

    CompanyResponse deleteCompanyById(Long id);

     CompanyConverterView findAllCompanies(String text, int page, int size);

    int numberOfStudents();
}
