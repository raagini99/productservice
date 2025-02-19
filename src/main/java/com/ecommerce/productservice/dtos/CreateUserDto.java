package com.ecommerce.productservice.dtos;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@Data
public class CreateUserDto {
    public String name;
    public String email;
    public List<Long> batchIds;
//    private List<String> batchNames;
}