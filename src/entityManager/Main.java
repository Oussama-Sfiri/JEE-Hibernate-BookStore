package entityManager;

import java.util.List;

import entity.Book;

public class Main {
    public static void main(String[] args) {
        BookEm bookEm = new BookEmImpl();
        
        Book newBook = new Book();
        newBook.setTitle("JAVA for Pro");
        newBook.setAuthor("Master Java");
        newBook.setPrice(19.99);
        
        // Delete the updated book
        System.out.println("Deleting the updated book...");
        List<Book> books = bookEm.bookFindByKw(newBook.getTitle());
        for(Book addedBook : books) {
            bookEm.deleteBook(addedBook.getBook_id());
        }


       /* 
        // Display all records
        System.out.println("Display all books:");
        List<Book> allBooks = bookEm.bookDisplayAll();
        for (Book book : allBooks) {
            System.out.println(book.getBook_id() + " "
            		+ book.getTitle() + " " 
            		+ book.getAuthor() + " " 
            		+ book.getPrice());
        }
        
        // Insert a new book
        System.out.println("Inserting a new book...");
        Book newBook = new Book();
        newBook.setTitle("JAVA for Pro");
        newBook.setAuthor("Master Java");
        newBook.setPrice(19.99);
        bookEm.bookAdd(newBook);

        // Display the new book
        System.out.println("Display the newly added book:");
        List<Book> books = bookEm.bookFindByKw(newBook.getTitle());
        for(Book addedBook : books) {
        	System.out.println(addedBook.getBook_id() + " "
            		+ addedBook.getTitle() + " "
            		+ addedBook.getAuthor() + " "
            		+ addedBook.getPrice());
        }

        // Update the price of the new book & Display the updated book
        System.out.println("Update the price of the new book:");
        List<Book> books = bookEm.bookFindByKw(newBook.getTitle());
        for(Book addedBook : books) {
            addedBook.setPrice(24.99);
            bookEm.updateBook(addedBook);
        	System.out.println(addedBook.getBook_id() + " "
            		+ addedBook.getTitle() + " "
            		+ addedBook.getAuthor() + " "
            		+ addedBook.getPrice());
        }

        // Delete the updated book
        System.out.println("Deleting the updated book...");
        List<Book> books = bookEm.bookFindByKw(newBook.getTitle());
        for(Book addedBook : books) {
            bookEm.deleteBook(addedBook.getBook_id());
        }
        
        */
    }
}

