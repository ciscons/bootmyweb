package com.myweb.basic;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JPAPageTest02 {

//	@Autowired
//	NoticeRepository noticeRepository;
	
//	@Test
//	@Disabled
//	void testCode01() {
//		for (int i = 1; i <= 300; i++) {
//			Notice notice = Notice.builder().noticedate("2022-08-06")
//							.writer("test" +  i)
//							.title("테스트" + i)
//							.content("테스트" + i)
//							.build();
//			noticeRepository.save(notice);
//		}
//	}
//	
//	@Test
//	@Disabled
//	void testCode02() {
//		
//		// 사용자가 조회하는 페이지가 1 페이지 일 떄, pageRequest에 넘어가야 하는 페이지 부분은 0이다.
//		Criteria cri = new Criteria(1, 10);
//		
//		
//		PageRequest pageable = PageRequest.of(cri.getPage() - 1, cri.getAmount(), Sort.by("nno").descending());
//		Page<Notice> notice = noticeRepository.findAll(pageable);
//		for(Notice n : notice.getContent()) {
//			System.out.println(n.toString());
//		}
//	}
	
	

}
