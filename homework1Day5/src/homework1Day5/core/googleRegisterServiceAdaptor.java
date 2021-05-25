package homework1Day5.core;

import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;
import homework1Day5.googleRegisterService.GoogleRegisterManager;

public class googleRegisterServiceAdaptor implements AuthorizedUserService{

	ValidationManager validation;
	UserDao userDao;
	
	public googleRegisterServiceAdaptor() {
		
	}

	public googleRegisterServiceAdaptor(ValidationManager validation, UserDao userDao) {
		this.validation = validation;
		this.userDao = userDao;
	}

	public boolean autorized(User user) {
		
		GoogleRegisterManager register = new GoogleRegisterManager();
		
		if(register.register(user)) {
			return true;
		}
		return false;
	}
}
