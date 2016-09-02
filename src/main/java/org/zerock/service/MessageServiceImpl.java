package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.MessageVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.MessageDAO;
import org.zerock.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService {

  @Inject
  private MessageDAO messageDAO;

  @Inject
  private PointDAO pointDAO;


  @Transactional
  @Override
  public void addMessage(MessageVO vo) throws Exception {

    messageDAO.create(vo);
    pointDAO.updatePoint(vo.getSender(), 10);
  }

  @Transactional
  @Override
  public MessageVO readMessage(String uid, Integer mid) throws Exception {

    messageDAO.updateState(mid);

    pointDAO.updatePoint(uid, 5);

    return messageDAO.readMessage(mid);
  }

@Override
public List<MessageVO> listSearchCriteria(SearchCriteria cri) throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int listSearchCount(SearchCriteria cri) throws Exception {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<MessageVO> listMessage(Integer mid) throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<MessageVO> listMessagePage(Integer mid, Criteria cri) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int count(Integer mid) {
	// TODO Auto-generated method stub
	return 0;
}
}
