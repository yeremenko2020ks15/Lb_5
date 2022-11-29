package com.example.accessingdatamysql;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.accessingdatamysql.MoneyCourse.WEB_OUTPUT;

@RestController
@Controller
public class WebApp {

    @GetMapping("/courses")
    public String printCourses() {
        return WEB_OUTPUT;
    }
}
