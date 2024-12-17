package com.koreait.board.bean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koreait.board.util.MyUtil;

import lombok.Data;
import org.slf4j.*;

@Component
@Data

public class ClassRoom {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private int no;

	@Autowired
	private Desk desk1;
	
	@Autowired
	private Desk desk2;
	
	@Autowired
	private Chair chair1;
	
	@Autowired
	private Chair chair2;
	
	public ClassRoom() {
		log.info(MyUtil.BLUE + "NEW ClassRoom OPEN!!!!" + MyUtil.END);
	}
}