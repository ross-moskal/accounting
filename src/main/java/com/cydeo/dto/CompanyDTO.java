package com.cydeo.dto;

import com.cydeo.enums.CompanyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    private Long id;
    private String title;
    private String phone;
    private String website;
    private AddressDTO address;
    private CompanyStatus companyStatus;
}
