package com.example.bootrestapi.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyRequest {

    private String companyName;

    private String locatedCountry;

}
