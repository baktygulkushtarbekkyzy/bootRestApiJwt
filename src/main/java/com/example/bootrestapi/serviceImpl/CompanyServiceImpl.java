package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.companyConverter.CompanyConverterView;
import com.example.bootrestapi.converter.companyConverter.CompanyRequestConverter;
import com.example.bootrestapi.converter.companyConverter.CompanyResponseConverter;
import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.model.Company;
import com.example.bootrestapi.repository.CompanyRepository;
import com.example.bootrestapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository ;
    private final CompanyResponseConverter companyResponseConverter;

    private final CompanyRequestConverter companyRequestConverter;

    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) throws IOException {
        Company company = companyRequestConverter.create(companyRequest);
        companyRepository.save(company);
       return companyResponseConverter.convertToResponse(company);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        companyRepository.save(company);
        return  companyResponseConverter.convertToResponse(company);
    }

    @Override
    public CompanyResponse getById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return companyResponseConverter.convertToResponse(company);
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        return companyResponseConverter.view(companyRepository.findAll());
    }

    @Override
    public CompanyResponse deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        companyRepository.delete(company);
        return  companyResponseConverter.convertToResponse(company);
    }

    @Override
    public int numberOfStudents() {
        return 0;
    }

    public CompanyConverterView findAllCompanies(String text,int page, int size){
        Pageable pageable=PageRequest.of(page -1,size);
        CompanyConverterView companyConverterView=new CompanyConverterView();
        companyConverterView.setCompanyResponseList(viewPagination(search(text,pageable)));
        return companyConverterView;
    }
    public List<CompanyResponse> viewPagination(List<Company> companies){
        List<CompanyResponse> companyResponseList=new ArrayList<>();
        for (Company company:companies) {
            companyResponseList.add(companyResponseConverter.convertToResponse(company));
        }
        return companyResponseList;
    }

    public List<Company> search(String name,Pageable pageable){
        String text=name==null ? "" : name;
        return companyRepository.searchPagination(text.toUpperCase(),pageable);
    }


}
