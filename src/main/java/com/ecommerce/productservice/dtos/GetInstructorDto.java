package com.ecommerce.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetInstructorDto extends CreateUserDto{
    private Double salary;
    private String skill;
}