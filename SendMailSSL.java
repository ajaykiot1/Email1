import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMailSSL extends HttpServlet
{
	public static void main(String ar[])
	{	
		String to ="ajay.kiot1@gmail.com";
		Properties ps=new Properties();
		ps.put("mail.smtp.host","smtp.gmail.com");
		ps.put("mail.smtp.socketFactory.port","465");
		ps.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		ps.put("mail.smtp.auth","true");
		ps.put("mail.smtp.port",465);
		
		try
		{
			Session se=Session.getDefaultInstance(ps,new MyAuth());
			
			MimeMessage msg=new MimeMessage(se);
			msg.setFrom(new InternetAddress("iplducat15@gmail.com"));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			msg.setSubject("Hello");
			
			Multipart body=new MimeMultipart();
			MimeBodyPart part1=new MimeBodyPart();
			part1.setText("This is body............");
			body.addBodyPart(part1);
			
			MimeBodyPart part2=new MimeBodyPart();
			FileDataSource fds=new FileDataSource("D:\\Baby.jpg");
			part2.setDataHandler(new DataHandler(fds));
			part2.setFileName(fds.getName());
			body.addBodyPart(part2);
			msg.setContent(body);
			Transport.send(msg);
			System.out.println("Message sent");
		}
		catch(Exception e)
		{
			System.out.println(e+"sssssss");
		}
		System.out.println("mail sent");
	}
}

class MyAuth extends javax.mail.Authenticator
{
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication("iplducact15@gmail.com", "ducat15#");
	}
}