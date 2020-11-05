package cn.com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestConller2 {


        @RequestMapping("/hello2")
        public String helle() {


            return "hello888";

        }
}
