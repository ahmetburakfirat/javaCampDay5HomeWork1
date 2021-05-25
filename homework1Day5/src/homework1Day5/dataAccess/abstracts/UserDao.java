package homework1Day5.dataAccess.abstracts;

import java.util.List;

import homework1Day5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	boolean checkIfEmailIsRegistered(User user);
	List<User> getAll();
}
