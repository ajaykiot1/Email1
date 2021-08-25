import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
import java.io.*;


public class ReadMail
{
	public static void main(String ar[]) throws Exception
	{
		Properties ps=new Properties();
		ps.put("mail.pop.host","pop.gmail.com");
		ps.put("mail.smtp.SocketFactory.port","995");
		ps.put("mail.smtp.SocketFactory.class","javax.net.ssl.SSLSocketFactory");
		
		String host="pop.gmail.com";
		String provider="pop3s";
		Session session=Session.getInstance(ps, new MyAuth());
		Store store =session.getStore(provider);
		store.connect(host, "iplducat15gmail.com", "ducat15#");
		System.out.println("Hello");
		
		Folder inbox=store.getFolder("INBOX");
		if(inbox==null)
		{
			System.out.println("No Inbox");
			System.exit(1);
		}
		//System.out.println("hello");
		
		inbox.open(Folder.READ_ONLY);
		Message[] message=inbox.getMessages();
		for(int i=0;i<message.length;i++)
		{
			System.out.println("message"+ (i+1));
			//message[i].writeTo(System.out);
		
		System.out.println("Sent Date : " + message[i].getSentDate());
		System.out.println("From : "+message[i].getFrom()[i]);
		System.out.println("Subject : "+message[i].getSubject());
		System.out.println("Size : " + message[i].getSize());
		System.out.println("Lines : "+ message[i].getLineCount());
		
		try
		{
			Multipart multipart=(Multipart)message[i].getContent();
			BodyPart plainTextPart=multipart.getBodyPart(i);
			System.out.println("----------Body---------");
			System.out.println(plainTextPart.getContent());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		try{
			Folder[] folder=store.getDefaultFolder().list();
		
		
		for(int i=0;i<folder.length;i++)
		{
			System.out.println("Folder name "+ folder[i].getFullName());
			//InputStream stream=message[i].getInputStream();
			//while(stream.available()!=0)
			//{
				//System.out.print((char)stream.read());
			//}
			
		}
		}
		catch(Exception e11)
		{}
	
	}
}
