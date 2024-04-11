package com.menora.eventsreader.controllers.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CompanyResponseDto {

    private String id;

    private String sourceCompany;

    List<InsuredResponseDto> insureds;

}
