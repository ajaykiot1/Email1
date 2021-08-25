<!DOCTYPE HTML>
<html lang="en-US">
<head>
	<meta charset="UTF-8">
	<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
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

			<form  name="form" action="mail" method="post" id="form" >
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
			 <input type="submit" value="submit" id="btnSubmit" />
			 <a href="upload.jsp"><input type="button" value="upload" id="btnSubmit" /></a>
			</form>
		</div>
	</div>
	
	
</body>
</html>