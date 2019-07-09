package com.tendecoders.libraraymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tendecoders.libraraymanagement.model.Book;
@Repository
//public interface BookRepository extends CrudRepository<Book, Long> {
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaRepository<Book,Long> {

}
