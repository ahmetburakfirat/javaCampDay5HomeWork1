package homework1Day5.business.concretes;

import homework1Day5.business.abstracts.UserLoginService;
import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;

public class UserLoginManager implements UserLoginService{

	UserDao userdao;
	
	public UserLoginManager(UserDao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void login(User user) {
		for (User user1 : userdao.getAll()) {
			if(user.getEmail() == user1.getEmail() && user.getPassword() == user1.getPassword()) {
				System.out.println("Başarılı giriş.");
				return;
			}
			System.out.println("Hatalı giriş.");
			return;
			
		}
		
	}

}
