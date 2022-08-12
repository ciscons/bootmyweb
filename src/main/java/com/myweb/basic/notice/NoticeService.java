package com.myweb.basic.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.util.Criteria;
import com.myweb.basic.util.PageDTO;

@Service
public interface NoticeService {
	
	Notice noticeReg(Notice notice); //notice entity를 전달받는다.
	PageDTO<Notice> getListAll(Criteria cri);
	Notice getDetail(long nno);
	List<Notice> getMyList(String userId);
	void noticeUpdate(Notice notice);
	void noticeDelete(Long nno);

}
