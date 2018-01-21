package com.pce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/sitter")
public class SitterSearchController {

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private SitterRankRepository sitterRankRepository;
//
//	@GetMapping(path = "/search")
//	public @ResponseBody Iterable<SitterRank> search(@RequestParam String rating) {
//		return sitterRankRepository.findAll();
//	}
//
//	@GetMapping(path = "/all")
//	public @ResponseBody SitterResponse getAll() {
//		return new SitterResponse(sitterRankRepository.findByOrderByRankDesc());
//	}
}