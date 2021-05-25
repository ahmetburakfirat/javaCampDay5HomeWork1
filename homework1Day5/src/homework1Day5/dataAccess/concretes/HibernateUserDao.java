package homework1Day5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homework1Day5.dataAccess.abstracts.UserDao;
import homework1Day5.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	private List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanıcı eklendi: " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public boolean checkIfEmailIsRegistered(User user) {
		for (User i : users) {
			if(i.getEmail() == user.getEmail()) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public List<User> getAll(){
		
		return users;
	}

	

	

}
