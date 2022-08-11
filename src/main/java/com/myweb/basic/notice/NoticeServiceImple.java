package com.myweb.basic.notice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myweb.basic.entity.Notice;

@Service
public class NoticeServiceImple implements NoticeService {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Override
	public Notice noticeReg(Notice notice) {
		return noticeRepository.save(notice);
		
	}

	@Override
	public List<Notice> getListAll() {
		return noticeRepository.findAll(Sort.by("nno").descending());
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

	

	
}
