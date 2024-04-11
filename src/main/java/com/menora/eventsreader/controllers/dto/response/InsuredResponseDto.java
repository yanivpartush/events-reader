package com.menora.eventsreader.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class InsuredResponseDto {

    private String id;


    private List<ProductResponseDto> products;
}
