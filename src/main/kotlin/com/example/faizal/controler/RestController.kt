package com.example.faizal.controler

import com.example.faizal.data.Title
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController {
    @GetMapping("/title")
    fun title(): ResponseEntity<Title> {
        val responseHeaders = HttpHeaders()
        responseHeaders["Access-Control-Allow-Origin"] = "*"
        return ResponseEntity.ok().headers(responseHeaders)
                .body(Title("App Title example Faizal Patel"))
    }
}