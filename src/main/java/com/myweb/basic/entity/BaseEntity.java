package com.myweb.basic.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass //해당 어노테이션을 붙이면 티에블로 사용하지 않고, 부모 클래스도 이동됨
@EntityListeners(AuditingEntityListener.class)  //JPA엔티티 관리를 영속성 영역세어 변화를 감지해서 자동으로 변수에 적용
@Getter
public class BaseEntity {

	//공동클래스 = VO나 모든 곳에서 사용 가능한 class
	@CreatedDate //생성시간
	@Column(name = "regdate", updatable = false)
	private LocalDateTime regdate;
	
	@LastModifiedDate //변경시간
	@Column(name = "moddate")
	private LocalDateTime moddate;
	
	//bootmywebApplication.java 클래스에 @EnableJpaAuditing 어노테이션을 추가해줘야 한다.
	
}
