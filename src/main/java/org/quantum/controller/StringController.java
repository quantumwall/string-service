package org.quantum.controller;

import org.quantum.model.Request;
import org.quantum.service.StringService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/string")
public class StringController {

    private final StringService stringService;

    @PostMapping("/count")
    public ResponseEntity<?> count(@RequestBody @Valid Request request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        var result = stringService.countLetters(request.string());
        return ResponseEntity.ok(stringService.sortByValue(result));
    }

    @GetMapping
    public String home() {
        return "Home";
    }

}