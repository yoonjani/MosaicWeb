package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.MessageVO;
import org.zerock.domain.SearchCriteria;

public interface MessageService {

	public void addMessage(MessageVO vo) throws Exception;

	public MessageVO readMessage(String uid, Integer mno) throws Exception;

	public List<MessageVO> listMessage(Integer mid) throws Exception;

	public List<MessageVO> listMessagePage(Integer mid, Criteria cri);

	public int count(Integer mid);

	List<MessageVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	int listSearchCount(SearchCriteria cri) throws Exception;
}
