package com.example.demo.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Book;

@Repository
public interface BookRepositoryInterface extends CrudRepository<Book, Long> {
	
//		books.add(new Book("Как закалялась сталь", 1938, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQuocjZqbeTCT0l4VJGIZc_9VBtA9iOyp6HjA&usqp=CAU", genres.get(0), authors.get(0)));
//		books.add(new Book("Маленький принц", 1958, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQdS5OdROIedW7Yg6NifgBCOmV9bVWcdCUb6g&usqp=CAU", genres.get(1), authors.get(1)));
//		books.add(new Book("Тихий дон", 1948, false, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSgqbXzoa9GQAMuSwNcBUjI_RSq-HnwblwbyA&usqp=CAU\" class=", genres.get(2), authors.get(2)));
//		books.add(new Book("Война и мир", 1888, true, "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSFBD1YM1DIN7KWPIUdcSY4s8SfOEJyclPNOw&usqp=CAU", genres.get(3), authors.get(3)));

}
