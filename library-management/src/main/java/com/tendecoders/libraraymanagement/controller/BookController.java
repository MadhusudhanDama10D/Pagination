package com.tendecoders.libraraymanagement.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tendecoders.libraraymanagement.model.Book;
import com.tendecoders.libraraymanagement.service.BookService;



@RestController
@RequestMapping("/books")
public class BookController {
		
		@Autowired
		BookService service;
		@PostMapping("/saveBook")
		public String saveBooks(@RequestBody Book book) {			
			service.create(book);
			return "sucess";
			
		}
		@GetMapping("page")
	    public ResponseEntity<List<Book>> getAllEmployees(

	                        @RequestParam(defaultValue = "0") Integer pageNo,

	                        @RequestParam(defaultValue = "3") Integer pageSize,

	                        @RequestParam(defaultValue = "id") String sortBy)

	    {

	        List<Book> list = service.getall(pageNo, pageSize, sortBy);

	        return new ResponseEntity<List<Book>>(list, new HttpHeaders(), HttpStatus.OK);

	    }
//		@GetMapping("/getBooks")
//		public String getBooks() {	
//			service.getall();
//			return "All records in tables";
//		}
//		@GetMapping("get/{bookid}")
//		private String getid(@PathVariable("bookid") long bookid)
//	{
//			
//			service.create(book);
//			return "success";
//	}
		@GetMapping(value="getbook/{bookid}")
		//public Book getById(@PathVariable("bookid") long bookid)
		public Book getById(@RequestBody Book book)
		{
			service.create(book);
			return book;

		}

	
	@DeleteMapping("/deleteBook/{bookid}")
		public void delete(@PathVariable int bookid ) {
		service.delete(bookid);
		}	
		@DeleteMapping("/delete")
		public String deleteAll()

		{
			
			long bookid = 0;
			service.deleteAll(bookid);
			return "All Books Are Deleted";
		}

}


