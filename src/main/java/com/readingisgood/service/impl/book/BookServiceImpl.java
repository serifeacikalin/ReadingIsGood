package com.readingisgood.service.impl.book;

import com.readingisgood.constant.ReadingIsGoodStatus;
import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.constant.ValidationErrorCode;
import com.readingisgood.entity.Books;
import com.readingisgood.model.book.BookDefinitionModel;
import com.readingisgood.model.book.BookListCriteriaModel;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.BookService;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.validation.BookValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private MapperService mapper;

    private BookRepository repository;
    private NumberGeneratorFactory numberGeneratorFactory;

    private BookValidator validator;

    @Override
    @Transactional
    public BookModel save(BookDefinitionModel bookModel) throws BusinessException {
        Books book = mapper.map(bookModel.getBookInfo(), Books.class);
        validator.validate(book);
        book.setStatus(ReadingIsGoodStatus.AKTIF.getValue());
        book.setRecordStatus(Boolean.TRUE);
        book.setBookNo((Long) numberGeneratorFactory.createGenerator(SequenceTableName.BOOK_NO_SEQ).generate());
        Books newRecord = repository.save(book);
        return mapper.map(newRecord, BookModel.class);
    }

    @Override
    public BookModel update(BookDefinitionModel bookModel) throws BusinessException {
        if(bookModel.getBookInfo() == null){
            throw new BusinessException(ValidationErrorCode.INVALID_INPUT);
        }
        Books book = mapper.map(bookModel.getBookInfo(), Books.class);
        validator.validate(book);
        Books relatedBook = repository.findByAuthorNameAndBookNameAndRecordStatusAndStatus(book.getAuthorName(), book.getBookName(), Boolean.TRUE, ReadingIsGoodStatus.AKTIF.getValue());
        relatedBook.setBookName(book.getBookName());
        relatedBook.setAuthorName(book.getAuthorName());
        relatedBook.setPublicationYear(book.getPublicationYear());
        relatedBook.setUpdatedUser(book.getCreatedUser());
        relatedBook.setStock(book.getStock() + relatedBook.getStock());
        book.setStatus(ReadingIsGoodStatus.AKTIF.getValue());
        book.setRecordStatus(Boolean.TRUE);
        Books newRecord = repository.save(relatedBook);
        return mapper.map(newRecord, BookModel.class);
    }

    @Override
    public List<BookModel> listBook(BookListCriteriaModel criteriaModel) {
        List<Books> bookList = repository.searchByCriteria(criteriaModel);
        return mapper.map(bookList, BookModel.class);
    }
}
