package com.example.bootrestapi.api;

import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyResponse> getAll(){
       return companyService.getAllCompany();
    }

    @PostMapping
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) throws IOException {
       return companyService.saveCompany(companyRequest);
    }

    @PostMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest){
        return companyService.updateCompany(id, companyRequest);
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable Long id){
        return companyService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CompanyResponse deleteById(@PathVariable Long id){
        return companyService.deleteCompanyById(id);
    }

}
