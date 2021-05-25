package homework1Day5;

import homework1Day5.business.abstracts.UserLoginService;
import homework1Day5.business.abstracts.UserService;
import homework1Day5.business.concretes.AuthorizedUserManager;
import homework1Day5.business.concretes.UserLoginManager;
import homework1Day5.business.concretes.UserManager;
import homework1Day5.core.EmailVerificationManager;
import homework1Day5.core.ValidationManager;
import homework1Day5.core.googleRegisterServiceAdaptor;
import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.dataAccess.concretes.HibernateUserDao;
import homework1Day5.entities.concretes.User;


public class Main {

	public static void main(String[] args) {
		
		UserDao dao = new HibernateUserDao();	//hem user managerda hem de googleuserda aynı List'i kullanmak için new'lendi.
		
		UserService userService = new UserManager(new ValidationManager(), new EmailVerificationManager(), dao);
		
		User user1 = new User(0, "ahmet", "fırat", "ahmetfirat@gmail.com", "123456");
		User user2 = new User(1, "ali", "fırat", "alifirat@gmail.com", "12345678");
		User user3 = new User(2, "veli", "fırat", "velifirat@gmail.com", "123456");
		User user4 = new User(3, "burak", "fırat", "burakfirat@gmail.com", "123456");
		
		userService.save(user1);
		userService.verify(user1);
		
		userService.save(user2);
		userService.verify(user2);
		
		
		System.out.println("*****************");
		
		
		UserService userServiceGoogle = new AuthorizedUserManager(new ValidationManager(), dao,new googleRegisterServiceAdaptor());
		
		userServiceGoogle.save(user3);
		
		userServiceGoogle.save(user3);	//Kayıtlı Email
		
		
		System.out.println("*****************");
		
		
		UserLoginService loginService = new UserLoginManager(dao);
		
		loginService.login(user1);	//Başarılı 
		loginService.login(user4);	//Hatalı
		
		

	}

}
