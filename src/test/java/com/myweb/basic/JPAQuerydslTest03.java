package com.myweb.basic;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.QNotice;
import com.myweb.basic.notice.NoticeRepository;
import com.myweb.basic.util.Criteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@SpringBootTest
public class JPAQuerydslTest03 {

	@Autowired
	NoticeRepository noticeRepository;

	@Test
	@Disabled
	public void testCode01() {
		// 페이지 조회
		Criteria cri = new Criteria(1, 10);
		PageRequest pageable = PageRequest.of(cri.getPage() - 1, cri.getAmount(), Sort.by("nno").descending());
		
		//쿼리DSQL Q클래스 사용
		QNotice qNotice = QNotice.notice;
		
		//불린빌더 (where 조건에 들어가는 조건을 넣는 객체
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		//조건을 표현
//		BooleanExpression express = qNotice.writer.eq("admin");
		BooleanExpression express = qNotice.writer.like("%2%");
		//불린빌더에 and, or를 이요해서 조건을 합침
		booleanBuilder.and(express);
		
		express = qNotice.content.like("%3%");
		booleanBuilder.and(express);
		express = qNotice.content.like("%4%");
		booleanBuilder.and(express);
		
		Page<Notice> result = noticeRepository.findAll(booleanBuilder, pageable);
		
		for(Notice n : result.getContent()) {
			System.out.println(n.toString());
		}
		
	}
	
	@Test
	@Disabled
	public void testCode02() {
		// 페이지 조회
		//화면에서는 page, amount, 검색 키워드를 넘긴다고 가정
		Criteria cri = new Criteria(1, 10);
		cri.setWriter("admin");
//		cri.setTitle("2");
		cri.setContent("3");
		PageRequest pageable = PageRequest.of(cri.getPage() - 1, cri.getAmount(), Sort.by("nno").descending());
		
		//Q도메인 클래스
		QNotice qNotice = QNotice.notice;
		//조건을 조합할 booleanbuilder
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		//동적쿼리
		//작성자 검색
		if(cri.getWriter() != null && !cri.getWriter().equals("")) { //writer가 null이 아니고, 공백이 아닐 때 writer가 있다는 의미임 
			//boolean express 표현
			booleanBuilder.and(qNotice.writer.like("%" + cri.getWriter() + "%"));
		}
		//타이틀 검색
		if(cri.getTitle() != null && !cri.getTitle().equals("")) {
			booleanBuilder.and(qNotice.title.like("%" + cri.getTitle() + "%"));
		}
		//컨텐츠 검색
		if(cri.getContent() != null && !cri.getContent().equals("")) {
			booleanBuilder.and(qNotice.content.like("%" + cri.getContent() + "%"));
		}
		
		Page<Notice> result = noticeRepository.findAll(booleanBuilder, pageable);
		
		for(Notice n : result.getContent()) {
			System.out.println(n.toString());
		}
	}
}
