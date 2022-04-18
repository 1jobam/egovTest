package com.test.board.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.board.dao.boardDao;
import com.test.board.service.BoardService;

@Service(value = "boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name = "boardDao")
	private boardDao boardDao;

}
