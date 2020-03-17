package com.capnwiggles.springboottodo.controller;

import com.capnwiggles.springboottodo.domain.Todo;
import com.capnwiggles.springboottodo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebAppController {

    @Autowired
    private TodoService service;

    @GetMapping("/")
    public String hello(Model model) {
        List<Todo> todos = service.findAllTodos();
        model.addAttribute("todos", todos);

        return "index";
    }

}
