package entityManager;

import java.util.List;

import entity.Book;

public interface BookEm {
	
    Book bookAdd(Book book);
    Book updateBook(Book book);
    void deleteBook(Long bookId);
    List<Book> bookDisplayAll();
    List<Book> bookFindByKw(String kw);
    
}
