package com.menora.eventsreader.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@AllArgsConstructor
@Builder
@Data
public class ProductResponseDto {

    private Long id;

    private String type;

    private Integer price;

    private Date startDate;

    private Date endDate;
}
