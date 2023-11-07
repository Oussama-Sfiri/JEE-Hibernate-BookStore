package entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Book;

public class BookEmImpl implements BookEm {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public BookEmImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Bookstore");
        entityManager = entityManagerFactory.createEntityManager();
    }


	@Override
	public Book bookAdd(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Book updateBook(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(book);
            entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public void deleteBook(Long bookId) {
        try {
            entityManager.getTransaction().begin();
            Book book = entityManager.find(Book.class, bookId);
            if (book != null) {
                entityManager.remove(book);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
	}

	@Override
	public List<Book> bookDisplayAll() {
		TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
	}

	@Override
	public List<Book> bookFindByKw(String kw) {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b FROM Book b WHERE b.Title LIKE :keyword", Book.class);
            query.setParameter("keyword", "%" + kw + "%");
            return query.getResultList();
	}

}
