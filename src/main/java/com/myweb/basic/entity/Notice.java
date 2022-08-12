package com.myweb.basic.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "NOTICE")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nno;
	
	@Column(length = 20)
	private String noticedate;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	@Column(length = 300, nullable = false)
	private String title;
	
	@Column(length = 2000)
	private String content;
	
	//OneToMany는 1쪽이 연관관계의 주인이 되는 형식입니다.
	//1쪽은 연관관계의 주인이 될수 없는 형식이기 때문에
	//mappedBy속성을 이용해서 연관관계의 주인을 n쪽으로 설정합니다
	//mappedBy는 연관테이블의 FK필드명이 들어갑니다.
//	@OneToMany(mappedBy = "notice_nno")
//	private List<Reply> replyList;
	
	//양방향을 그냥 꽂아넣으면 toString 메소드가 서로 참조하다가 꼬이게 된다.
	//그래서 한 쪽의 toString을 제거해줘야 한다.
	@OneToMany(mappedBy = "notice", fetch = FetchType.LAZY)
	private List<Reply> replyList;
	
}
