package com.example.shopmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shippers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shippers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipperId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "shippers", cascade = CascadeType.ALL)
    private List<Orders> orderses = new ArrayList<>();

}
