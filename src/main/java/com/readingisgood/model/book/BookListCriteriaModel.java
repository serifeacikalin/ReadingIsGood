package com.readingisgood.model.book;

import lombok.Data;

@Data
public class BookListCriteriaModel {
    private String bookName;
    private String authorName;
    private Long orderNo;
    private Long bookNo;
}
