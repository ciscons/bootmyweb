package com.myweb.basic;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageTest01 {
	
//	@Autowired
//	ProductMapper productMapper;
	//insert 600번
	/*
	@Test
	public void testCode01() {
		
		for(int i = 1; i <= 600; i++) {
			
			ProductVO vo= ProductVO.builder()
								.prod_enddate("2022-08-02")
								.prod_writer("admin")
								.prod_name("admin" + i)
								.prod_price(i)
								.prod_count(i)
								.prod_discount(i)
								.prod_purchase_yn("N")
								.prod_content("test" + i)
								.prod_comment("test" + i)
								.build();
			
			productMapper.productRegist(vo);
								
			
		}
	}
	*/
	
	/*
	@Test
	public void testCode02() {
		//Criteria cri = new Criteria(); //page = 1, amount = 10;
		Criteria cri = new Criteria(2, 20); //page = 2, amount= 20;
		
		List<ProductVO> list= productMapper.getList(cri);
		
		for(ProductVO vo : list) {
			System.out.println(vo.toString());
		}
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
