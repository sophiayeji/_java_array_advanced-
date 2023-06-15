package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession; //sql연결

	@Override
	public void insertBoard(BoardDTO boardDTO) throws Exception {
		sqlSession.insert("boardMapper.insertBoard", boardDTO);		
	}

	@Override
	public List<BoardDTO> selectListBoard() throws Exception {
		return sqlSession.selectList("boardMapper.selectListBoard");		
	}

	@Override
	public void updateReadCnt(long boardId) throws Exception {
		sqlSession.update("boardMapper.updateReadCnt", boardId);		
	}

	@Override
	public BoardDTO selectOneBoard(long boardId) throws Exception {
	//	BoardDTO boardDTO = sqlSession.selectOne("boardMapper.selectOneBoard",boardId);
	//	return null;
		return sqlSession.selectOne("boardMapper.selectOneBoard",boardId);
	}

	@Override
	public String SelectOnePasswd(long boardId) throws Exception {
		return sqlSession.selectOne("boardMapper.selectOnePasswd", boardId);
	}

	@Override
	public void updateBoard(BoardDTO boardDTO) throws Exception {
		sqlSession.update("boardMapper.updateBoard", boardDTO);
		
	}

	@Override
	public void deleteBoard(long boardId) throws Exception {
		sqlSession.delete("boardMapper.deleteBoard", boardId);		
	}	
}
