package com.example.shopmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private Long supplierId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @Column(name = "units_on_order")
    private Integer unitsOnOrder;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(name = "discontinued")
    private boolean discontinued;

    @ManyToOne
    @JoinColumn(name = "supplier_id", updatable = false, insertable = false)
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn(name = "category_id", updatable = false, insertable = false)
    private Categories category;

    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails = new ArrayList<>();

}
