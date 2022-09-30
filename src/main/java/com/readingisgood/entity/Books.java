package com.readingisgood.entity;

import com.readingisgood.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_book")
public class Books extends BaseEntity {

    @Column(name = "book_no",length = 10)
    private Long bookNo;

    @Column(name = "book_name",length = 200)
    private String bookName;

    @Column(name = "author_name",length = 200)
    private String authorName;

    @Column(name = "publication_year")
    private String publicationYear;

    @Column(name = "book_stock",length = 10)
    private Long stock;

    @Column(name = "book_amount", precision = 18, scale = 2)
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
