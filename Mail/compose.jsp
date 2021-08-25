<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<div class="outer">
		<header>
			<div id="logo"></div>
			<div id="poster">
			<h1>Welcome to mailing system</h1>
			</div>
		</header>
		<div class="content">
		<span id="result"></span>
		<%
			try
			{
				String msg=session.getAttribute("sent").toString();
		%>		
				<h2 style="text-align:center; color:red;"><%out.println(msg);%><h2>
		<%	
				session.removeAttribute("sent");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		%>
		<div class="content-left">
			<a href="http://localhost:7002/Mail/sendmail.jsp"><input type="button" value="Compose" /></a>
			<a href="http://localhost:7002/Mail/read"><input type="button" value="Inbox" /></a>
			<a href="http://localhost:7002/Mail/sent"><input type="button" value="Sent" /></a>
			<a href="http://localhost:7002/Mail/draft"><input type="button" value="Draft" /></a>
			<a href="http://localhost:7002/Mail/trace"><input type="button" value="Trace" /></a>
		</div>
		<div class="content-right"><br>
			<form  name="form" action="mail" id="form" >
			<label for="em">To : </label><br>
			<input type="email" id="em" name="email"/><br>
			<label for="sub">Subject :</label><br>
			<input type="text" id="sub" name="sub"/><br>
			<label for="msg">Message :</label><br>
			<textarea name="msg" id="msg"  rows="10"></textarea><br>
			<!--
			<script>
			 CKEDITOR.replace( 'msg' );
			 </script> -->
			 <label for="file">Attachment :</label><br>
			 <input type="file" id="file" name="file"/><br>			
			<input type="submit" value="submit" id="btnSubmit" />
			</form>
			<br>
		</div>
		</div>
	</div>
</body>
</html>