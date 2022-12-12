package com.example.bootrestapi.serviceImpl;

import com.example.bootrestapi.converter.companyConverter.CompanyRequestConverter;
import com.example.bootrestapi.converter.companyConverter.CompanyResponseConverter;
import com.example.bootrestapi.dto.company.CompanyRequest;
import com.example.bootrestapi.dto.company.CompanyResponse;
import com.example.bootrestapi.model.Company;
import com.example.bootrestapi.repository.CompanyRepository;
import com.example.bootrestapi.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        int r = 0;
//        for (Company c : getAllCompany()) {
//            for (Course s : c.getCourses()) {
//                for (Group g : s.getGroups()) {
//                    for (Student e : g.getStudents()) {
//                        System.out.println(e);
//                        r++;
//                    }
//                }
//            }
//        }
        return r;
    }
}
