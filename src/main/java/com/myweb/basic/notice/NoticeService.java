package com.myweb.basic.notice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.basic.entity.Notice;

@Service
public interface NoticeService {
	
	Notice noticeReg(Notice notice); //notice entity를 전달받는다.
	List<Notice> getListAll();
	Notice getDetail(long nno);
	List<Notice> getMyList(String userId);

}
