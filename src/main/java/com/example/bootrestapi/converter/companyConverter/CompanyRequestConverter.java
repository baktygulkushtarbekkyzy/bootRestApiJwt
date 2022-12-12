package com.example.bootrestapi.converter.companyConverter;

import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyRequestConverter {

    public Company create(CompanyRequest companyRequest){
        if(companyRequest==null){
            return  null;
        }
        Company company=new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }


}
