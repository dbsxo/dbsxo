package model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.BoardMapper;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	
	public static BoardDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Board> listBoard(Search search, int startRow){
		SqlSession session = getSqlSessionFactory().openSession();
		List<Board> list = null;
		try {
			list = session.getMapper(BoardMapper.class).listBoard(search, new RowBounds(startRow,2));
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public int insertBoard(Board board) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(BoardMapper.class).insertBoard(board);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public Board detailBoard(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		Board board = null;
		try {
			board = session.getMapper(BoardMapper.class).detailBoard(seq);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return board;
	}
	
	public int updateBoard(Board board) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(BoardMapper.class).updateBoard(board);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public int deleteBoard(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(BoardMapper.class).deleteBoard(seq);
			if(re>0) {
				session.commit();
				System.out.println("delete성공");
			}else {
				session.rollback();
				System.out.println("delete실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public int countBoard(Search search) {
		SqlSession session = getSqlSessionFactory().openSession();
		int count = 0;
		try {
			count = session.getMapper(BoardMapper.class).countBoard(search);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return count;
	}
	
	public int replyInsert(Reply reply) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(BoardMapper.class).replyInsert(reply);
			if(re>0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public List<Reply> replySelect(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Reply> reply = null;
		try {
			reply = session.getMapper(BoardMapper.class).replySelect(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return reply;
	}

}
