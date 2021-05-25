package homework1Day5.business.concretes;

import homework1Day5.business.abstracts.UserService;
import homework1Day5.core.AuthorizedUserService;
import homework1Day5.core.ValidationManager;
import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;

public class AuthorizedUserManager implements UserService{

	ValidationManager validation;
	UserDao userDao;
	AuthorizedUserService auService;
	
	public AuthorizedUserManager(ValidationManager validation, UserDao userDao, AuthorizedUserService auService) {
		this.validation = validation;
		this.userDao = userDao;
		this.auService = auService;
	}

	@Override
	public void save(User user) {
		if(auService.autorized(user)) {
			if(userDao.checkIfEmailIsRegistered(user)) {
				System.out.println("Kayıt işlemi başarısız. E-posta adresi sisteme zaten kayıtlı.");
			}else {
				userDao.add(user);
			}
			return;
		}
		
		System.out.println("Bu mail adresi google'a kayıtlı değildir.");
	}

	@Override
	public void verify(User user) {
		
		
	}

}
