package com.test.board.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.board.service.BoardService;
import com.test.util.AbstractBaseController;
import common.Logger;

@Controller
public class BoardController extends AbstractBaseController{
	
	private static Logger logger = Logger.getLogger(BoardController.class);
	
	@Resource(name="boardService")
	private BoardService boardService;

	@RequestMapping(value = "/boardList.do")
	private String boardList(HashMap<String, Object> commandMap, ModelMap model, HttpServletRequest request){
		return "board/boardList";
	}
}
