package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Sample2VO;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return "hello world !!";
	}
	
	@RequestMapping("/sendVO")
	public Sample2VO sendVO () {
		
		Sample2VO vo = new Sample2VO();
		vo.setFirstName("Hyunkeun");
		vo.setLastName("Lee");
		vo.setMno(123);
		
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<Sample2VO> sendList() {
		List<Sample2VO> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			Sample2VO vo = new Sample2VO();
			vo.setFirstName("Hyunkeun");
			vo.setLastName("Lee");
			vo.setMno(123);
			list.add(vo);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, Sample2VO> sendMap() {
		Map<Integer, Sample2VO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			Sample2VO vo = new Sample2VO();
			vo.setFirstName("Hyunkeun");
			vo.setLastName("Lee");
			vo.setMno(123);
			map.put(i, vo);
		}
		
		return map;
	}

}
