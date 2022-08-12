package com.myweb.basic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="REPLY")
@Getter
@Setter
@ToString(exclude= "notice") //notice 필드는 toString 제외
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincreament
	private Long rno; //pk
	@Column(length = 50)
	private String writer; //작성자
	@Column(length = 500)//
	private String text; //내용
	
//	@ManyToOne(fetch=FetchType.LAZY) //연관관계쪽에서 N쪽 테이블에 FK가 들어가게 된다. (다대일 단방향)
	//ManyToOne 은 기본적으로 EAGER join을 사용한다. 하지만 성능 저하의 이슈가 있기 때문에 LAZY를 사용한다.
	//LAZY join을 사용하는 경우 Transactional을 사용해야 한다.
//	private Notice notice; //다대일 관계
	
//	private Long notice_nno; //Notice에서 OneToMany를 사용하기 위해 등록함
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Notice notice;
}
