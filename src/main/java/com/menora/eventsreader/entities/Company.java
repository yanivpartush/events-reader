package com.menora.eventsreader.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "accept_date")
    private Date acceptDate;

    @Column(name = "source_company")
    private String sourceCompany;

    @OneToMany(mappedBy = "company"
            , fetch = FetchType.EAGER
            , cascade = { CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Insured> insureds;


}
