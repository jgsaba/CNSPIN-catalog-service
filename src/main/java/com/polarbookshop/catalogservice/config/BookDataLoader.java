package com.polarbookshop.catalogservice.config;

import com.polarbookshop.catalogservice.domain.entities.Book;
import com.polarbookshop.catalogservice.domain.repositories.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository repository;
    public BookDataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        var book1 = new Book("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90);

        var book2 = new Book("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90);

        repository.save(book1);
        repository.save(book2);
    }
}
