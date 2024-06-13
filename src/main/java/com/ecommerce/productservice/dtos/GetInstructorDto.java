package com.ecommerce.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

//commenting
@Getter
@Setter
public class GetInstructorDto {
    private UUID id;
    private String name;
    private String email;
    private List<String> batchName;
    private List<Long> batchId;
}
