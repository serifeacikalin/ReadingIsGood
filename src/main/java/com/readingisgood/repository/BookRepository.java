package com.readingisgood.repository;

import com.readingisgood.entity.Books;
import com.readingisgood.model.book.BookListCriteriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

    @Query("SELECT b FROM Books b WHERE b.recordStatus = true and " +
            "(:#{#p.bookNo} is null or b.bookNo = :#{#p.bookNo}) and " +
            "(:#{#p.bookName} is null or b.bookName = :#{#p.bookName}) and " +
            "(:#{#p.authorName} is null or b.authorName = :#{#p.authorName})")
    List<Books> searchByCriteria(@Param("p") BookListCriteriaModel criteriaModel);

    Books findByAuthorNameAndBookNameAndRecordStatusAndStatus(String authorName, String bookName, Boolean recordStatus, String status);

    Books findByRecordStatusAndStatusAndBookNo(Boolean recordStatus, String status, Long bookNo);
}