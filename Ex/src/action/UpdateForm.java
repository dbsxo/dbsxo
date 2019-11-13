package action;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class UpdateForm implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		request.setAttribute("seq", seq);
		
		forward.setPath("/updateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
