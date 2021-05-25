package homework1Day5.business.abstracts;

import homework1Day5.entities.concretes.User;

public interface VerificationService {
	void sendMail(User user);
	void verify(User user);
}
