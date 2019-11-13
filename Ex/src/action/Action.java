package action;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public interface Action {
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws HTTPException, IIOException;
	
	

}
