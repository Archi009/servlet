package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class TestExe {
	public static void main(String[] args) {
		//DataSource class를 인스턴스화 해서 SqlSessionFactory를 만들어준다.
		SqlSessionFactory sqlSessionFactory = DataSource.getInstence();
		//sqlSessionFactory의 openSession메소드를 이용해 session을 만들어준다
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			//session의 selectList(select메소드 중 하나)매개변수에 내가 실행할 쿼리문이 담긴 실행문의 namespace를 담아주고 실행문의 반환타입에 맞는 변수에 담아 준다. 
////			List<BoardVO> list = session.selectList("com.yedam.mapper.BoardMapper.selectAll");
////			
////			for(BoardVO bo :list) {
////				System.out.println(bo);
////			}
//			//mapper 에 담겨서 함께 넘어 가 줄 매개 변수를 selectone 메소드의 두번째 매개변수로 담아준다 
//			BoardVO bo2 =session.selectOne("com.yedam.mapper.BoardMapper.selectBoard",1734);
//			
//			System.out.println(bo2);
//			
//		}
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			  BoardMapper mapper = session.getMapper(BoardMapper.class);
			  
			  BoardVO bo = new BoardVO();
			  bo.setTitle("mybatis등록3");
			  bo.setContent("잘되나요3");
			  bo.setWriter("나요3");
			  
//			  int cnt = mapper.insertBoard(bo);
			  int cnt = mapper.deleteBoard(1706);
			  //등록 삭제 수정은 commit을 해야 결과가 적용된다 
			  if(cnt>0) {
				  System.out.println("성공");
				  //그래서 session.commit을 해 주는데 매번 이걸 적어주기보단 session을 열어 줄 때 true값을 넣어주자
//				  session.commit(true);
			  }else {
				  System.out.println("실패");
			  }
			  
			  List<BoardVO> list = mapper.selectAll();
			  for(BoardVO vo : list) {
				  System.out.println(vo);
			  }
			  
			}
	}
	
}
