package com.koreait.board.mapper;

import com.koreait.board.bean.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 게시글 추가
 * @return BoardMapper
 */
@Mapper
public interface BoardMapper {
    public int insert(BoardVO vo);

    /**
     * bno 채번 결과를 vo에 담는다
     * @param vo
     * @return insertSelectKey()
     */
    public int insertSelectKey(BoardVO vo);

    /**
     * 게시글 리스트
     * @return 게시글 리스트
     */
    public List<BoardVO> getList();


}
