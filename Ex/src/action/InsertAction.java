package action;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import model.BoardService;

public class InsertAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		BoardService sc = BoardService.getInstance();
		
		int re = 0;
		re = sc.insertBoard(request);
		
		forward.setPath("list.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
