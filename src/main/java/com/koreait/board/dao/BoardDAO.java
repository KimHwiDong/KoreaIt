package com.koreait.board.dao;

import com.koreait.board.bean.BoardVO;
import com.koreait.board.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    private BoardMapper mapper;

            //getList
    public List<BoardVO> getList(){
        return mapper.getList();
    }
    //register
    public int register(BoardVO board){
        return mapper.insertSelectKey(board);
    }
    //read
    public BoardVO read(Long bno){
        return  mapper.get(bno);
    }
    //modify
    public int modify(BoardVO board){
        return mapper.update(board);
    }
}
