package com.myweb.basic.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.Reply;
import com.myweb.basic.notice.NoticeService;
import com.myweb.basic.util.Criteria;
import com.myweb.basic.util.PageDTO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/noticeListAll")
	public String noticeListAll(@ModelAttribute("cri") Criteria cri, Model model) {
		
		//페이지
		PageDTO<Notice> list = noticeService.getListAll(cri);
		model.addAttribute("pageDTO", list);
		
		return "notice/noticeListAll";
	}
	
	@GetMapping("/noticeReg")
	public String noticeReg() {
		return "notice/noticeReg";
	}
	
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("nno") long nno,
							   Model model) {
		
		Notice notice = noticeService.getDetail(nno);
		
		System.out.println(notice.toString());
		
		model.addAttribute("vo", notice);
		return "notice/noticeDetail";
	}
	
	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam("nno") long nno,
							   @RequestParam("writer") String writer,
							   HttpSession session,
							   Model model) {
		
		String userId = (String)session.getAttribute("userId");
		//글 작성자와 세션의 저장된 로그인된 사용자가 다르면 수정 화면에 진입할 수 없게끔 막아준다.
		if(userId.equals(writer) == false) {
			return "redirect:/notice/noticeListAll";
		}
		Notice notice = noticeService.getDetail(nno);
		model.addAttribute("vo", notice);
		
		return "notice/noticeModify";
	}
	
	@PostMapping("/noticeUpdate")
	public String noticeUpdate(Notice notice) {
		
		noticeService.noticeUpdate(notice);
		
		return "redirect:/notice/noticeListMe";
	}
	
	@PostMapping("/noticeDelete")
	public String noticeDelete(@RequestParam("nno") long nno) {
		
		noticeService.noticeDelete(nno);
		
		return "redirect:/notice/noticeListMe";
	}
	
	@GetMapping("/noticeListMe")
	public String noticeListMe(HttpSession session,
							   Model model) {
		//1. session에 저장된 값을 얻는다.(session.userId)
		//2. JPA로 JPQL이나 Query method 사용 가능, repository에 writer기반 조회하는 구문 작성
		//3. 반환은 List<Notice> 타입입니다.
//		List<Notice> list = noticeService.getMyList();
		
		String userId = (String)session.getAttribute("userId");
		List<Notice> list = noticeService.getMyList(userId);
		model.addAttribute("list", list);
		
//		for(Notice n : list) {
//			System.out.println(n.toString());
//		}
		
		return "notice/noticeListMe";
	}
	
	//폼등록요청
	@PostMapping("/noticeForm")
	public String noticeForm(Notice notice) {
		
		Notice n = noticeService.noticeReg(notice);
		System.out.println(n);
		
		return "redirect:/notice/noticeListAll";
	}
	
	
}
