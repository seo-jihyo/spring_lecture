package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl {
	@Autowired
	private ReplyDAO replyDAO;

	public Integer insertReply(ReplyVO vo) {
		return replyDAO.insertReply(vo);
	}
	
	public List<ReplyVO> selectAllReply(int bno){
		System.out.println("didi");
		return replyDAO.selectAllReply(bno);
	}
	
	public int deleteReply(String rno) {
		return replyDAO.deleteReply(rno);
	}
	public  Integer updateReply(ReplyVO vo){
		return replyDAO.updateReply(vo);
	}

}
