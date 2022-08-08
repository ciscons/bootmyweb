package com.myweb.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.basic.command.CategoryVO;
import com.myweb.basic.product.ProductService;

@RestController
public class AjaxController {
	
	@Autowired
	ProductService productService; //상품
	
	
	//매개변수는 없고 반환만 있는 모형(첫번쨰 카테고리)
	@GetMapping("/getCategory")
	public List<CategoryVO> getCategory() {
		
		List<CategoryVO> list = productService.getCategory();
		return list;
	}
	
	//필요한 값은 Post방식으로 전달하고, 반환이 있는 모형(두번째, 세번째 카테고리)
	@PostMapping("/getCategoryChild")
	public List<CategoryVO> getCategoryChild(@RequestBody CategoryVO vo) {
		
		List<CategoryVO> list = productService.getCategoryChild(vo);
		
		return list;
	}
	
	
}






