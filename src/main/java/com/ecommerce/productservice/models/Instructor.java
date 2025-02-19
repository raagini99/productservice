package com.ecommerce.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Instructor extends User {
    private Double salary;
    private String skill;
    //Lazy by default for Lists.
    //mappedBy = "instructor"
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //Association specs
    //@JoinColumn(name = "batch_id") //Doesn't work cos there's no equivalent of batch_id in instructor table.
    //Remove parameters to create a batch_instructor join table.
    @Fetch(FetchMode.JOIN)
    private List<Batch> batches;

    /*public List<Long> getBatchIds() {
        List<Long> batchIds = new ArrayList<>();
        for(Batch batch: batches) {
            batchIds.add(batch.getId());
        }
        return batchIds;
    }
    */
}