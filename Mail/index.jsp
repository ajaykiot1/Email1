<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
	<link rel="stylesheet" href="styles.css" />
	<meta charset="UTF-8">
</head>
<%@ page import="javax.mail.internet.*"%>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="java.io.*"%>
<%@ page import="javax.mail.Store"%>
<%@ page import="javax.mail.Session"%>
<%@ page import="javax.mail.PasswordAuthentication"%>
<%@ page import="javax.mail.Message"%>
<%@ page import="javax.mail.Folder"%>
<%@ page import="javax.mail.Authenticator"%>
<%@ page import="java.util.*"%>
<body>
	<div class="outer">	
	<header>
		<div id="logo"></div>
		<div id="poster">
			<h1>Welcome to mailing system</h1>
		</div>
	</header>
	<div class="content">
		<div class="content-left">
			<a href="http://localhost:7002/Mail/compose.jsp"><input type="button" value="Compose" /></a>
			<a href="http://localhost:7002/Mail/read"><input type="button" value="Inbox" /></a>
			<a href="http://localhost:7002/Mail/sent"><input type="button" value="Sent" /></a>
			<a href="http://localhost:7002/Mail/draft"><input type="button" value="Draft" /></a>
			<a href="http://localhost:7002/Mail/trace"><input type="button" value="Trace" /></a>
		</div>
		<div class="content-right">
		<%
			
			Properties ps=new Properties();
			ps.put("mail.pop.host","pop.gmail.com");
			ps.put("mail.smtp.SocketFactory.port","995");
			ps.put("mail.smtp.SocketFactory.class","javax.net.ssl.SSLSocketFactory");
			
			String host="pop.gmail.com";
			String provider="pop3s";
			Store store;
			Session se=Session.getInstance(ps,new javax.mail.Authenticator() {
                                protected PasswordAuthentication 
                                      getPasswordAuthentication() {
                                    return new PasswordAuthentication
                                      ("iplducact15@gmail.com", "ducat15#");
                                }
                            });
			try
			{
				store =se.getStore(provider);
				store.connect(host, "iplducact15@gmail.com", "ducat15#");
				out.println("Hello");
			
			Folder inbox=store.getFolder("INBOX");
			if(inbox==null)
			{
				out.println("No Inbox");
				System.exit(1);
			}
			inbox.open(Folder.READ_ONLY);
			Message[] message=inbox.getMessages();
			//for(int i=0;i<=message.length;i++)
			//{
			out.println("Sent Date : " + message[50].getSentDate());
			out.println("From : "+message[50].getFrom()[50]);
			out.println("Subject : "+message[50].getSubject());
			//out.println("Size : " + message[i].getSize());
			//out.println("Lines : "+ message[i].getLineCount());
			//Multipart multipart=(Multipart)message[i].getContent();
			//BodyPart plainTextPart=multipart.getBodyPart(i);
			//out.println("----------Body---------");
			//out.println(plainTextPart.getContent());
			}
			//}
			catch(Exception e)
			{
				out.println(e);
			}
			
		%>
		</div>
	</div>	
	</div>
</body>
</html>