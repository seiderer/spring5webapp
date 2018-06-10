package de.seidererp.spring5webapp.bootstrap;

import de.seidererp.spring5webapp.model.Author;
import de.seidererp.spring5webapp.model.Book;
import de.seidererp.spring5webapp.model.Publisher;
import de.seidererp.spring5webapp.repositories.AuthorRepository;
import de.seidererp.spring5webapp.repositories.BookRepository;
import de.seidererp.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper_collins = new Publisher("Harper Collins");
        publisherRepository.save(harper_collins);
        Book  ddd = new Book("Domain Driven Design", "1234", harper_collins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox");
        publisherRepository.save(wrox);
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
