package com.javassem.dao;

import java.util.List;

import com.javassem.domain.ReplyVO;

public interface ReplyDAO {

	public Integer insertReply(ReplyVO vo); 
	public List<ReplyVO> selectAllReply(int bno);
	public int deleteReply(String rno);

	public Integer updateReply(ReplyVO vo);
}
