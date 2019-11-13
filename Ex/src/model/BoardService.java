package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BoardService {
	private static BoardService sc = new BoardService();
	private static BoardDao dao;
	private static final int PAGE_NO = 2;
	
	public static BoardService getInstance() {
		dao = BoardDao.getInstance();
		return sc;
	}
	
	public ListModel listBoard(HttpServletRequest request){
		Search search = new Search();
		HttpSession session = request.getSession();
		
		
		if(request.getParameterValues("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
		}else if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		
		int totalCount = dao.countBoard(search);
		
		int totalPageCount = totalCount/PAGE_NO;
		if(totalCount%PAGE_NO > 0) {
			totalPageCount++;
		}
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		int startPage = requestPage - (requestPage-1)%5;
		
		int endPage = startPage+4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage -1) * PAGE_NO;

		
		List<Board> list = dao.listBoard(search, startRow);
		
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
		
	}
	
	public int insertBoard(HttpServletRequest request) {
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContents(request.getParameter("contents"));
		board.setFname("1");
		
		int re = 0;
		re = dao.insertBoard(board);
		return re;
		
		
	}
	
	public Board detailBoard(int seq) {
		return dao.detailBoard(seq);
	
	}
	
	public int updateBoard(Board board) {
		
		
		int re = dao.updateBoard(board);
		return re;
		
	}
	
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}
	
	public int replyInsert(Reply reply) {
		return dao.replyInsert(reply);
	}
	
	public List<Reply> replySelect(int seq){
		return dao.replySelect(seq);
	}

}
