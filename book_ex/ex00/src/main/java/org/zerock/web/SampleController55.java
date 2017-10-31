package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController55 {

	@RequestMapping("/doJSON2")
	public @ResponseBody ProductVO doJSON2() {
		
		ProductVO vo = new ProductVO("JSON", 10000.1);

		return vo;
	}
}
