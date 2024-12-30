package com.koreait.board.controller;

import com.koreait.board.bean.BoardVO;
import com.koreait.board.dao.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardDAO dao;

    // register글쓰기 화면 호출용
    @GetMapping("register")
    public void register(){

    }
    // register(글쓰기) 처리용
    @PostMapping("register")
    public void write(BoardVO board){
        log.info("writing : " + board);
        log.info(dao.register(board) + "is complete");
    }
}
