import java.util.*;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import java.io.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadMail extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		Properties ps=new Properties();
		ps.put("mail.pop.host","pop.gmail.com");
		ps.put("mail.smtp.SocketFactory.port","995");
		ps.put("mail.smtp.SocketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		String host="pop.gmail.com";
		String provider="pop3s";
		Store store;
		Session session=Session.getInstance(ps, new MyAuth());
		try
		{
			store =session.getStore(provider);
			store.connect(host, "iplducat15@gmail.com", "ducat15#");
		out.println("Hello");
		
		Folder inbox=store.getFolder("INBOX");
		if(inbox==null)
		{
			out.println("No Inbox");
			System.exit(1);
		}
		//System.out.println("hello");
		
		inbox.open(Folder.READ_ONLY);
		Message[] message=inbox.getMessages();
		out.println("Sent Date : " + message[0].getSentDate());
		out.println("From : "+message[0].getFrom()[0]);
		out.println("Subject : "+message[0].getSubject());
		out.println("Size : " + message[0].getSize());
		out.println("Lines : "+ message[0].getLineCount());
		Multipart multipart=(Multipart)message[0].getContent();
			BodyPart plainTextPart=multipart.getBodyPart(0);
			out.println("----------Body---------");
			out.println(plainTextPart.getContent());
		}
		catch(Exception e)
		{
			out.println(e);
		}/*
		
		Folder[] folder=store.getDefaultFolder.list();
		for(int i=0;i<folder.length;i++)
		{
			System.out.println("Folder name "+ folder[i].getName());
			
		}*/
	
	}
	
}