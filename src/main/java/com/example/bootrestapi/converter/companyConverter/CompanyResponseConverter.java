package com.example.bootrestapi.converter.companyConverter;

import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Component
public class CompanyResponseConverter {

    public CompanyResponse convertToResponse(Company company){
        return new CompanyResponse(company.getId(), company.getCompanyName(), company.getLocatedCountry());
    }






    public List<CompanyResponse> view(List<Company> companies){
        List<CompanyResponse> companyResponses=new ArrayList<>();
        for (Company c:companies) {
            companyResponses.add(convertToResponse(c));
        }
        return companyResponses;
    }
}
