package homework1Day5.business.concretes;

import java.util.ArrayList;
import java.util.List;

import homework1Day5.business.abstracts.UserService;
import homework1Day5.business.abstracts.VerificationService;
import homework1Day5.core.ValidationManager;
import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;

public class UserManager implements UserService{

	private List<String> emails = new ArrayList<String>();
	ValidationManager validation;
	VerificationService verify;
	UserDao userDao;
	

	public UserManager(ValidationManager validation, VerificationService verify, UserDao userDao) {
		this.validation = validation;
		this.verify = verify;
		this.userDao = userDao;
	}


	@Override
	public void save(User user) {
		if(validation.valid(user, emails, userDao)) {
			verify.sendMail(user);
		}
		
		
	}


	@Override
	public void verify(User user) {
		verify.verify(user);
		userDao.add(user);
	}

}
