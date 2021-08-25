import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.oreilly.servlet.*;

public class GetPath extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String to=req.getParameter("email");
		String sub=req.getParameter("sub");
		String msg=req.getParameter("msg");
		out.println(to);
		out.println(sub);
		out.println(msg);
		System.out.println("Hello" + to);	
		/*
		String path=getServletContext().getRealPath("/file");
		MultipartRequest mpr=new MultipartRequest(req,path,500*1024*1024);
		String s1=mpr.getOriginalFileName("file");
		*/
		//out.println("<html><body>");
		//out.println("File successfully uploaded ");
		//out.println("</body></html>");
	}
}
