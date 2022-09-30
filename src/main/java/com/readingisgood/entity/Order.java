package com.readingisgood.entity;

import com.readingisgood.entity.common.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "t_order")
public class Order extends BaseEntity {

    @Column(name = "order_no",length = 10)
    private Long orderNo;

    @Column(name = "order_count",length = 10)
    private Long orderCount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<Books> books;
    public void addBook(Books book){
        book.setOrder(this);
    }
}
