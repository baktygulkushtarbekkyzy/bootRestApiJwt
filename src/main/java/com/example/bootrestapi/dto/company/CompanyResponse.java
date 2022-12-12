package com.example.bootrestapi.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyResponse {

    private Long id ;

    private String companyName;

    private String locatedCountry;


}
