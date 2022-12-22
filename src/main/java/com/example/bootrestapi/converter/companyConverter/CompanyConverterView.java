package com.example.bootrestapi.converter.companyConverter;

import com.example.bootrestapi.dto.company.CompanyResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyConverterView {
    List<CompanyResponse> companyResponseList;
}
