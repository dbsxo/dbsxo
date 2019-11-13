package action;

import java.util.List;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import model.Board;
import model.BoardService;
import model.Reply;

public class DetailAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		BoardService sc = BoardService.getInstance();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		Board board = sc.detailBoard(seq);
		
		List<Reply> reply = sc.replySelect(seq);
		
		request.setAttribute("reply", reply);
		request.setAttribute("board", board);
		
		forward.setPath("/detail.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
