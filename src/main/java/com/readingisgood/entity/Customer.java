package com.readingisgood.entity;

import com.readingisgood.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "t_customer")
public class Customer extends BaseEntity {

    @Column(name = "customer_no",length = 10)
    private Long customerNo;

    @Column(name = "customer_name",length = 50)
    private String customerName;

    @Column(name = "customer_mail",length = 50)
    private String email;

    @Column(name = "phone_number",length = 50)
    private String phoneNumber;

    @Column(name = "customer_address",length = 50)
    private String address;

    @Column(name = "ıdentity_number",length = 50)
    private String identityNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Order> order;
}
