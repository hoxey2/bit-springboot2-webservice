package com.example.web.springboot.web;

import com.example.web.springboot.config.auth.LoginUser;
import com.example.web.springboot.config.auth.dto.SessionUser;
import com.example.web.springboot.service.PostsService;
import com.example.web.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

    @RequiredArgsConstructor
    @Controller
    public class IndexController {

    @GetMapping
    public String index() {
        return "index";  //     src/main/resource/templates/*.mustache
    }

//    private final PostsService postsService;
    @GetMapping
    public String postsSave() {
        return "post-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }
}