package com.readingisgood.model.book;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookModel {
    private Long id;
    private String bookName;
    private String authorName;
    private String publicationYear;
    private String createdUser;
    private Long stock;
    private Long bookNo;
    private BigDecimal amount;
}
