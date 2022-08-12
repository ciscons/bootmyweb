package com.myweb.basic.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.myweb.basic.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>,QuerydslPredicateExecutor<Notice> { //엔티티, PK타입

	//파라미터는 : 을 붙이고 파라미터 명을 입력하면 된다.
	@Query("select n from Notice n where n.writer = :userId")
	Page<Notice> getMyList(@Param("userId") String userId, Pageable pageable);
	
//	Page<Notice> findAll;
	
	
	
	
}
