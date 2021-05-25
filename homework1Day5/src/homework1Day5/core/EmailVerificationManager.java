package homework1Day5.core;

import homework1Day5.business.abstracts.VerificationService;
import homework1Day5.entities.concretes.User;

public class EmailVerificationManager implements VerificationService{

	@Override
	public void sendMail(User user) {
		System.out.println("E-posta adresine doğrulama mesajı yollanmıştır. " + user.getEmail());
		
	}

	@Override
	public void verify(User user) {
		System.out.println("hesap doğrulanmıştır.");
		
	}

}
