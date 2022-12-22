package com.example.bootrestapi.api;

import com.example.bootrestapi.converter.companyConverter.CompanyConverterView;
import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@PreAuthorize("hasAuthority('ADMIN')")
public class CompanyController {

    private final CompanyService companyService;

//    @PreAuthorize()
    @GetMapping
    @PreAuthorize("permitAll()")
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
    @PreAuthorize("permitAll()")
    public CompanyResponse getById(@PathVariable Long id){
        return companyService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CompanyResponse deleteById(@PathVariable Long id){
        return companyService.deleteCompanyById(id);
    }


    @GetMapping("/search")
    public CompanyConverterView getAllCompanyPage(@RequestParam(name="text",required = false)String text,
                                                  @RequestParam int page,
                                                  @RequestParam int size){
        return companyService.findAllCompanies(text, page, size);
    }
}
