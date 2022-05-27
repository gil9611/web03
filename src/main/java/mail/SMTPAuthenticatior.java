package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
public class SMTPAuthenticatior extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		//네이버 아이디 패스워드
		return new PasswordAuthentication("elfgil2003","Password");
	}
}
