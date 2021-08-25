import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class MyAuth extends javax.mail.Authenticator
{
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication("iplducat15@gmail.com","ducat15#");
	}
}