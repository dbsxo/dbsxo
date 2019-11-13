package action;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import model.BoardService;

public class DeleteAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		BoardService sc = BoardService.getInstance();
		
		System.out.println("왔네");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		System.out.println(seq);
		
		sc.deleteBoard(seq);
		
		System.out.println("여긴 오나");
		forward.setPath("list.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
