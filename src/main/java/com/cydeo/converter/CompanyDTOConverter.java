package com.cydeo.converter;

import com.cydeo.dto.CompanyDTO;
import com.cydeo.service.CompanyService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CompanyDTOConverter implements Converter<String, CompanyDTO> {
    private final CompanyService companyService;

    public CompanyDTOConverter(@Lazy CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public CompanyDTO convert(String id) {
        if (id == null || id.isBlank())
            return null;
        return companyService.findCompanyById(Long.parseLong(id));
    }
}
