package action;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class InsertFormAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws HTTPException, IIOException {
		ActionForward forward = new ActionForward();
		
		forward.setPath("/insertForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
