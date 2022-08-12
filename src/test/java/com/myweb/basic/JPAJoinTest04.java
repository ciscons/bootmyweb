package com.myweb.basic;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myweb.basic.entity.Notice;
import com.myweb.basic.entity.Reply;
import com.myweb.basic.notice.NoticeRepository;
import com.myweb.basic.reply.ReplyRepository;

@SpringBootTest
public class JPAJoinTest04 {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	
//	@Test
//	@Disabled
//	public void testCode01() {
//		
//		//reply의 더미 데이터
//		for(int i = 1; i <= 500; i++) {
//			try {
//				//랜덤 값을 뽑아야 됨
//				long ran = (long)(Math.random() * 610) + 1; //1부터 610까지의 랜덤 값
//				
//				Notice notice = Notice.builder().nno(ran).build();
//				
//				Reply reply = Reply.builder().writer("test" + i).text("test" + i).notice(notice).build();
//				replyRepository.save(reply); //저장
//			} catch (Exception e) {
//				System.out.println("참조칼럼없음");
//			}
//		}
//		 
//	}
	
	@Transactional
	@Test
	@Disabled
	public void testCode02() {
		Optional<Reply> result = replyRepository.findById(100L);
		if(result.isPresent()) {
			Reply reply = result.get();
			System.out.println(reply.toString());
		}
	}
	
	@Transactional
	@Test
	public void testCode03() {
		Optional<Notice> result = noticeRepository.findById(589L);
		
		if(result.isPresent()) {
			Notice n = result.get();
			System.out.println(n.toString());
		}
	}
}
