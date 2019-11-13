package mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import model.Board;
import model.Reply;
import model.Search;

public interface BoardMapper {
	List<Board> listBoard(Search search, RowBounds rowBounds);
	
	int insertBoard(Board board);
	
	Board detailBoard(int seq);
	
	int updateBoard(Board board);
	
	int deleteBoard(int seq);
	
	int countBoard(Search search);
	
	int replyInsert(Reply reply);
	
	List<Reply> replySelect(int seq);

}
