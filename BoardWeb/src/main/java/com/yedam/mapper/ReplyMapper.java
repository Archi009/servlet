package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public List<Map<String, Object>> chartData();
	public int replyCount(int baordNo);
	public List<ReplyVO> replyList (Map<String, Integer> replyParam);
//	위의 메소드를 매개값이 int로 바꿔서 두개의 int를 보내는 방법이다. 
//	public List<ReplyVO> replyList (@param("boardNo) int boardNo, @param("page") int page);

	public ReplyVO selectReply(int replyNo);
	public int insertReply(ReplyVO vo);
	public int delReply(int replyNo);
}
