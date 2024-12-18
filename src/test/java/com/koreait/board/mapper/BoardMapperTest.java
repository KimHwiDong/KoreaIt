package com.koreait.board.mapper;

import com.koreait.board.bean.BoardVO;
import com.koreait.board.util.MyUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BoardMapperTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BoardMapper mapper;

    @Test
    @Transactional
    public void insertTest(){

        BoardVO vo = new BoardVO();
        vo.setTitle("자동제목");
        vo.setContent("테스트");
        vo.setWriter("테스터");
        
        //if (mapper.insert(vo) == 1){
        if(mapper.insertSelectKey(vo) == 1){
            log.info(MyUtil.BLUE + "INSERT 성공"+ MyUtil.END);
        }else{
            log.info(MyUtil.BLUE + "INSERT 실패"+ MyUtil.END);
        }

            log.info("BoardVO = " + vo.getBno());

        for(int i = 0; i < 15; i++){
            vo = new BoardVO();
            vo.setTitle("테스트" + i);
            vo.setContent("test" + i);
            vo.setWriter("me");
            mapper.insert(vo);
        }
    }

    @Test
    public void testGetList(){
        mapper.getList().forEach(board -> log.info(board.toString()));
    }
}
