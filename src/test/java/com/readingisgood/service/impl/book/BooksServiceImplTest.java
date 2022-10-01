package com.readingisgood.service.impl.book;

import com.readingisgood.constant.SequenceTableName;
import com.readingisgood.entity.Books;
import com.readingisgood.model.book.BookDefinitionModel;
import com.readingisgood.model.book.BookListCriteriaModel;
import com.readingisgood.model.book.BookModel;
import com.readingisgood.repository.BookRepository;
import com.readingisgood.service.MapperService;
import com.readingisgood.service.NumberGeneratorFactory;
import com.readingisgood.service.exception.BusinessException;
import com.readingisgood.service.repository.NumberGenerator;
import com.readingisgood.service.validation.BookValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BooksServiceImplTest {

    @Mock
    private MapperService mapper;

    @Mock
    private BookRepository repository;

    @Mock
    private NumberGeneratorFactory numberGeneratorFactory;

    @Mock
    private NumberGenerator numberGenerator;

    @Mock
    private BookValidator validator;

    @InjectMocks
    private BookServiceImpl service;

    @Test
    public void  saveBook_shouldBookRecord_whenBookNameNotEmpty() throws BusinessException {
        when(mapper.map(bookDefinitionModel.getBookInfo(), Books.class)).thenReturn(book);
        when(numberGeneratorFactory.createGenerator(SequenceTableName.BOOK_NO_SEQ)).thenReturn(numberGenerator);
        when(numberGenerator.generate()).thenReturn(BOOK_NO);
        when(repository.save(book)).thenReturn(book);
        when(mapper.map(book, BookModel.class)).thenReturn(bookModel);
        BookModel result = service.save(bookDefinitionModel);
        assertEquals(BOOK_NO,result.getBookNo());
    }

    @Test
    public void  listBook_shouldBookList_whenBookNoNotEmpty() throws BusinessException {
        when(repository.searchByCriteria(criteriaModel)).thenReturn(bookList);
        when(mapper.map(bookList, BookModel.class)).thenReturn(bookModels);
        List<BookModel> resultList = service.listBook(criteriaModel);
        assertTrue(resultList.size()>0);
    }

    private static BookDefinitionModel bookDefinitionModel = new BookDefinitionModel();
    private static BookModel bookModel = new BookModel();
    private static List<BookModel> bookModels = new ArrayList<>();
    private static Books book = new Books();
    private static List<Books> bookList = new ArrayList<>();
    private static List<BookDefinitionModel> bookDefinitionModelList = new ArrayList<>();
    private static BookListCriteriaModel criteriaModel = new BookListCriteriaModel();
    private static final Long BOOK_NO = 1111L;

    static {
       bookModel.setBookName("kitap1");
       bookModel.setAuthorName("yazar1");
       bookModel.setBookNo(BOOK_NO);
       bookModel.setPublicationYear("2022");
       bookModel.setStock(2L);
       bookDefinitionModel.setBookInfo(bookModel);
       bookModels.add(bookModel);

        book.setBookName("kitap1");
        book.setAuthorName("yazar1");
        book.setBookNo(BOOK_NO);
        book.setPublicationYear("2022");
        book.setStock(2L);

        criteriaModel.setBookName("kitap1");
        criteriaModel.setBookNo(BOOK_NO);

        bookList.add(book);
        bookDefinitionModelList.add(bookDefinitionModel);
    }
}