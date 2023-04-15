package com.cydeo.service.impl;

import com.cydeo.dto.CompanyDTO;
import com.cydeo.entity.Company;
import com.cydeo.enums.CompanyStatus;
import com.cydeo.repository.CompanyRepository;
import com.cydeo.service.CompanyService;
import com.cydeo.utils.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final MapperUtil mapperUtil;

    public CompanyServiceImpl(CompanyRepository companyRepository, MapperUtil mapperUtil) {
        this.companyRepository = companyRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CompanyDTO findCompanyById(Long id) {
        return mapperUtil.convert(companyRepository.findCompanyById(id), new CompanyDTO());
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository
                .findAll()
                .stream()
                .filter(company -> company.getId() != 1)
                .sorted(Comparator.comparing(Company::getCompanyStatus).thenComparing(Company::getTitle))
                .map(each -> mapperUtil.convert(each, new CompanyDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO create(CompanyDTO companyDTO) {
        companyDTO.setCompanyStatus(CompanyStatus.PASSIVE);
        Company company = companyRepository.save(mapperUtil.convert(companyDTO, new Company()));
        return mapperUtil.convert(company, new CompanyDTO());
    }

    @Override
    public boolean isTitleExist(String title) {
        return companyRepository.existsByTitle(title);
    }

    @Override
    public CompanyDTO update(Long companyId, CompanyDTO companyDTO) {
        Company savedCompany = companyRepository.findCompanyById(companyId);
        companyDTO.setId(companyId);
        companyDTO.setCompanyStatus(savedCompany.getCompanyStatus());
        companyDTO.getAddress().setCountry(savedCompany.getAddress().getCountry());
        companyDTO.getAddress().setId(savedCompany.getAddress().getId());
        Company updatedCompany = mapperUtil.convert(companyDTO, new Company());
        companyRepository.save(updatedCompany);
        return mapperUtil.convert(updatedCompany, new CompanyDTO());
    }
}
