package com.myweb.basic.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.QNotice;
import com.myweb.basic.util.Criteria;
import com.myweb.basic.util.PageDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class NoticeServiceImple implements NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Override
	public Notice noticeReg(Notice notice) {
		return noticeRepository.save(notice);
		
	}

	@Override
	public PageDTO<Notice> getListAll(Criteria cri) {
//		PageRequest pageable = PageRequest.of(cri.getPage() -1 , cri.getAmount(), Sort.by("nno").descending());
//		Page<Notice> result = noticeRepository.findAll(pageable);
		
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
		PageDTO<Notice> pageDTO = new PageDTO<>(result);
		
		return pageDTO;
	}

	@Override
	public Notice getDetail(long nno) {
		Optional<Notice> result = noticeRepository.findById(nno);
		
		//결과가 있을 수도 있고, 없을 수도 있기 때문임
		if(result.isPresent()) {
			Notice notice = result.get();
			return notice;
		}else {
			return null;
		}
	}

	@Override
	public List<Notice> getMyList(String userId) {
		
		PageRequest page = PageRequest.of(0, 10, Sort.by("nno").descending());
		Page<Notice> result = noticeRepository.getMyList(userId, page);
		
		return result.getContent();
	}

	@Override
	public void noticeUpdate(Notice notice) {
		Optional<Notice> result = noticeRepository.findById(notice.getNno());
		if(result.isPresent()) {
			// 앞에서 noticedate 값은 넘겨주지 않았기 때문에 null로 넘어온다. 그래서 가져온 내용의 nno로 DB에서 값을 조회, 그 값에 수정한 값을 대입하여 save한다. 
			Notice vo = result.get(); // vo를 꺼낸다.
			vo.setContent(notice.getContent());
			vo.setTitle(notice.getTitle());
			
			noticeRepository.save(vo);
		} else {
			
		}
		
	}

	@Override
	public void noticeDelete(Long nno) {
		
		noticeRepository.deleteById(nno);;
		
	}

	

	
}
