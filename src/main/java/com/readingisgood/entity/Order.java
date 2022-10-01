package com.readingisgood.entity;

import com.readingisgood.entity.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order extends BaseEntity {

    @Column(name = "order_no",length = 10)
    private Long orderNo;

    @Column(name = "order_count",length = 10)
    private Long orderCount;

    @Column(name = "order_date")
    private LocalDate orderDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private Set<Books> books;
    public void addBook(Books book){
        book.setOrder(this);
    }
}
