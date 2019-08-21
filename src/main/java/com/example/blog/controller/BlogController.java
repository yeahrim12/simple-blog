package com.example.blog.controller;

import com.example.blog.vo.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BlogController {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    // client 요청을 처리해주기 위한 method
    public String sayHello() {
        return "Hello, Yelim!";
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public Member getInfo() { //반환 값이 객체
        Member member = new Member(1, "Yelim, Jeon", "ojkjkjk@naver.com");

        return member;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Member> list() {
        List<Member> memberList = Arrays.asList(new Member[]{new Member(1,"Yelim, Jeon","ojkjkjk@naver.com"),
        new Member(2,"Yelim2, Jeon","2ojkjkjk@naver.com"),
        new Member(3,"Yelim3, Jeon","3ojkjkjk@naver.com"),
        new Member(4,"Yelim4, Jeon","4ojkjkjk@naver.com"),
        new Member(5,"Yelim5, Jeon","5ojkjkjk@naver.com")});

        // ########### test
        long startTime = System.currentTimeMillis();
        for (Member member : memberList) {
            System.out.println(member);
        }
        System.out.println("for-loop: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        memberList.forEach(System.out::println); // 람다식
        System.out.println("lambda: " + (System.currentTimeMillis() - startTime) + "ms");

        // ###############

        return memberList;
    }
}
