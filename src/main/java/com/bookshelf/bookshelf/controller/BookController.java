package com.bookshelf.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshelf.bookshelf.data.BookDTO;
import com.bookshelf.bookshelf.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ModelAndView getAll() {
        return new ModelAndView("book/index", "book", service.getAll());
    }

    @GetMapping("/new")
    public ModelAndView newBook() {
        return new ModelAndView("book/form", "book", new BookDTO());
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@ModelAttribute("book") BookDTO book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("book/form");
        }

        service.save(book);
        return new ModelAndView("redirect:/books");
    }

    @GetMapping(path = "/update/{id}")
    public ModelAndView update(@PathVariable("id") long id) {
        return new ModelAndView("book/form", "book", service.findByID(id));
    }
    
    @GetMapping(path = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {
        service.delete(id);

        return new ModelAndView("redirect:/books");
    }
    
}
