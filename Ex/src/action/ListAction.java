package action;

import java.util.List;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import model.Board;
import model.BoardService;
import model.ListModel;

public class ListAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		BoardService sc = BoardService.getInstance();
		
		ListModel listModel = sc.listBoard(request);
		
		request.setAttribute("listModel", listModel);
		
		forward.setPath("/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
