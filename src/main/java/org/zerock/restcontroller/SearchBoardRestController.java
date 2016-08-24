package org.zerock.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;

@RestController
@RequestMapping("/rboard")
public class SearchBoardRestController {

	static Logger logger = LoggerFactory.getLogger(SearchBoardRestController.class);

	@Inject
	BoardService service;

	@RequestMapping(value = "/list")
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		logger.info(cri.toString());

		List<BoardVO> boards = service.listCriteria(cri);

		return boards; // Marshall
	}

	@RequestMapping(value = "/listAll")
	public ResponseEntity<String> listAll(Criteria cri, HttpServletResponse response) throws Exception {
		logger.info(cri.toString());
		response.setContentType("application/json");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK); // Marshall
	}

}
