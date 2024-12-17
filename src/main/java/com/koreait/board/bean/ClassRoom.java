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

	public Logger getLog() {
		return log;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Desk getDesk1() {
		return desk1;
	}

	public void setDesk1(Desk desk1) {
		this.desk1 = desk1;
	}

	public Desk getDesk2() {
		return desk2;
	}

	public void setDesk2(Desk desk2) {
		this.desk2 = desk2;
	}

	public Chair getChair1() {
		return chair1;
	}

	public void setChair1(Chair chair1) {
		this.chair1 = chair1;
	}

	public Chair getChair2() {
		return chair2;
	}

	public void setChair2(Chair chair2) {
		this.chair2 = chair2;
	}

	@Autowired
	private Chair chair1;
	
	@Autowired
	private Chair chair2;
	
	public ClassRoom() {
		log.info(MyUtil.BLUE + "NEW ClassRoom OPEN!!!!" + MyUtil.END);
	}
}
