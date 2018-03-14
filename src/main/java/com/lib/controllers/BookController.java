package com.lib.controllers;

import com.lib.model.pojo.Book;
import com.lib.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@SessionAttributes("username")
public class BookController {
    private static Logger LOGGER = Logger.getLogger(BookController.class.getName());
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/getuserbooks", method = RequestMethod.GET)
    protected ModelAndView getBooks(ModelMap model) {
        String username = "";
        try{
            if(model.containsAttribute("username")) {
                username = (String) model.get("username");
                List<Book> books = bookService.getUserBooks(username);
                List<Book> allBooks = bookService.getAllBooks();

                model.addAttribute("userbooks", books);
                model.addAttribute("allbooks", allBooks);

                return new ModelAndView("/dashboard", model);
            }
        }
        catch (Exception e){
            System.out.println("Could'nt add attribute books");
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/readbook", method = RequestMethod.POST)
    protected ModelAndView addBook(@ModelAttribute("bookId") int bookId, ModelMap model) {
        String username = "";

        try{
            if(model.containsAttribute("username")) {
                System.out.println("adding new book to aa user");
                username = (String) model.get("username");
                System.out.println("BOOK ID: " + bookId);
                bookService.saveBookByUserName(username, bookId);

                return getBooks(model);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Could'nt add attribute books");
            LOGGER.warning(e.getMessage());
        }
        return new ModelAndView("redirect:/");
    }
}