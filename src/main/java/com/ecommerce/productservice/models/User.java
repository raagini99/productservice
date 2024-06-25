package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
// telling hibernate to create a table for you
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    // 49d97be6-a46c-4ea5-8f38-056e59dada8a

    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
