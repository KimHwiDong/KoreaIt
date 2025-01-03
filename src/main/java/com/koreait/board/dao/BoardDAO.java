package com.koreait.board.dao;

import com.koreait.board.bean.BoardVO;
import com.koreait.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private BoardMapper mapper;

    //getList
    public List<BoardVO> getList(){
        return mapper.getList();
    }
    public List<BoardVO> getListWithKey(String type, String keyword){
        return mapper.getListWithKey(type, keyword);
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
    //remove
    public int remove(Long bno){
        return mapper.delete(bno);
    }
}
