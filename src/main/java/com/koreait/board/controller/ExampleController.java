package com.koreait.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.board.bean.ArtVO;
import com.koreait.board.util.MyUtil;

import jakarta.servlet.http.HttpServletRequest;
@Controller

@RequestMapping("/ex/*")  // localhost:10000/ex는 제껍니다
public class ExampleController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@GetMapping("")
	public void nothing() {
		log.info("Nothing Method is called");
	}
	
	@GetMapping("sports")
	public void getSports() {  
	// Controller에서 void는 메서드가 종료되면 자동으로 Mapping keyword로 이동한다.
	// void getSports()는 template/ex/sports.html을 찾고 있음
		log.info(MyUtil.BLUE + "My favorite sports is the golf." + MyUtil.END);
	}
	
	@PostMapping("sports")
	public String postSports() {  
	// Controller에서 void는 메서드가 종료되면 자동으로 Mapping keyword로 이동한다.
	// void getSports()는 template/ex/sports.html을 찾고 있음
		log.info(MyUtil.BLUE + "My favorite sports is the baseball." + MyUtil.END);
		return "index";
	}
	
	@GetMapping("music")
	public String getMusic() {
		log.info(MyUtil.BOLD + "My favorite music is the classical music" + MyUtil.END);
		return "/ex/sports";
	}
	
	// classic way
	// http://localhost:10000/ex/classic?title=nocturne&artist=Chopin
	@GetMapping("classic")
	public String classicTest(HttpServletRequest req) {
		String title = req.getParameter("title");
		String artist = req.getParameter("artist");
		log.info("classic : " + title + "(" + artist + ")");
		return "index";
	}

	// spring way I
	// http://localhost:10000/ex/modern?title=nocturne&artist=Chopin
	@GetMapping("modern")
	public String modern(String title, String artist) {
		log.info("modern : " + title + "(" + artist + ")");
		return "index";
	}
	
	// spring way II
	// http://localhost:10000/ex/future?title=nocturne&artist=Chopin
	@GetMapping("future")
	public String future(ArtVO artVO, String title) {
		log.info("future : " + artVO);
		log.info("future : " + title);
		return "index";
	}
	
	// http://localhost:10000/ex/play?t=nocturne&a=Bach
	@GetMapping("play")
	public String play(@RequestParam("t") String title, 
			           @RequestParam("a") String artist) {
		log.info("play : " + title + "(" + artist + ")");
		return "index";
	}
	
	@GetMapping("query")
	public void query(@ModelAttribute("MyModel") ArtVO vo, String desc) {
		vo.setTitle("Piano Concerto No.1");
		vo.setArtist("차이코프스키");
		vo.setDesc(desc);
	}

	@GetMapping("subject")
	public void subject(){}
	
	@GetMapping("subjectVO")
	public String subjectVO(Model model, int kor, int math, int eng) {
		// Model을 이용하여 kor 10점, math 20점, eng 40점을 subjectVO.html로 전달하시오.
		// subjectVO.html에서는 kor, math, eng 점수를 받아서 출력하시오.
		// html에서 과목 점수 합계와 평균을 출력하시오.
		model.addAttribute("kor", kor);
		model.addAttribute("math", math);
		model.addAttribute("eng", eng);
		model.addAttribute("sum", kor+ math+ eng);
		model.addAttribute("avg",(kor+math+eng)/3F);
		return "/ex/subjectVO";
	}
}