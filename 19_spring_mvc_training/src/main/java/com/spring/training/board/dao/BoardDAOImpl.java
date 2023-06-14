package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession; //sql연결

	@Override
	public void insertBoard(BoardDTO boardDTO) {
		sqlSession.insert("boardMapper.insertBoard", boardDTO);		
	}

	@Override
	public List<BoardDTO> selectListBoard() {
		return sqlSession.selectList("boardMapper.selectListBoard");		
	}

	@Override
	public void updateReadCnt(long boardId) {
		sqlSession.update("boardMapper.updateReadCnt", boardId);		
	}

	@Override
	public BoardDTO selectOneBoard(long boardId) {
	//	BoardDTO boardDTO = sqlSession.selectOne("boardMapper.selectOneBoard",boardId);
	//	return null;
		return sqlSession.selectOne("boardMapper.selectOneBoard",boardId);
	}	
}
