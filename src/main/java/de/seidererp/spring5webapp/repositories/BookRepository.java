package de.seidererp.spring5webapp.repositories;

import de.seidererp.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
