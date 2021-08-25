import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.mail.*;
import com.oreilly.servlet.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		HttpSession se1=req.getSession();
		
		String to =req.getParameter("email");
		String sub=req.getParameter("sub");
		String msg1=req.getParameter("msg");
		
	
		
		/*
		String path=getServletContext().getRealPath("/file");
		MultipartRequest mpr=new MultipartRequest(req,path,500*1024*1024);
		String s1=mpr.getOriginalFileName("file");
		String path1=path+"\\"+s1;  */
		
		Properties ps=new Properties();
		
		ps.put("mail.smtp.host","smtp.gmail.com");
		ps.put("mail.smtp.socketFactory.port","465");
		ps.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		ps.put("mail.smtp.auth","true");
		ps.put("mail.smtp.port",465);
		
		try
		{
			Session se=Session.getInstance(ps,new MyAuth());
			
			MimeMessage msg=new MimeMessage(se);
			msg.setFrom(new InternetAddress("iplducat15@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			msg.setSubject(sub);
			
			Multipart body=new MimeMultipart();
			MimeBodyPart part1=new MimeBodyPart();
			part1.setText(msg1);
			body.addBodyPart(part1);
			
			MimeBodyPart part2=new MimeBodyPart();
			FileDataSource fds=new FileDataSource("D:\\Baby.jpg");
			part2.setDataHandler(new DataHandler(fds));
			part2.setFileName(fds.getName());
			body.addBodyPart(part2);
			msg.setContent(body);
			Transport.send(msg);
			se1.setAttribute("sent","Email sent successfully");
			res.sendRedirect("sendmail.jsp");
		}
		catch(NullPointerException ne)
		{
			out.println("Please fill form properly ");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}