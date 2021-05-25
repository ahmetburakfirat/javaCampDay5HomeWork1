package homework1Day5.core;

import java.util.List;

import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;

public class ValidationManager {
	public boolean valid(User user, List<String> emails, UserDao userDao) {
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || 
				user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("Kayıt işlemi başarısız. Lütfen zorunlu alanları doldurunuz.");
			return false;
		}
		
		if(user.getPassword().length() < 6) {
			System.out.println("Kayıt işlemi başarısız. Parola en az 6 karakterden oluşmalıdır.");
			return false;
		}
		
		RegexManager regexManager = new RegexManager();
		if(!regexManager.checkEmailFormat(user.getEmail())) {
			System.out.println("Kayıt işlemi başarısız. E-posta formatı uygun değil.");
			return false;
		}
		
		if(user.getFirstName().length() < 2 || user.getLastName().length() < 2) {
			System.out.println("Kayıt işlemi başarısız. İsim ve Soyisim en az 2 karakterli olmalıdır.");
			return false;
		}
		if(userDao.checkIfEmailIsRegistered(user)) {
			System.out.println("Kayıt işlemi başarısız. E-posta adresi sisteme zaten kayıtlı.");
			return false;
		}
		return true;
		
	}
}
